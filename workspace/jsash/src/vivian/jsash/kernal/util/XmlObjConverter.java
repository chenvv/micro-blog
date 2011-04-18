package vivian.jsash.kernal.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import vivian.jsash.kernal.exception.ConverterException;

public class XmlObjConverter {

	private static XmlObjConverter instance = null;

	private static DocumentBuilderFactory factory;
	private static TransformerFactory factoryT;
	private static DocumentBuilder builder;
	private static Transformer trans;

	private SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-DD kk:mm:ss.SSS");

	public static final String ATTR_CLASS = "class";
	public static final String ATTR_COMPONENT = "component";
	public static final String ATTR_COMPONENT1 = "component1";
	public static final String ATTR_NAME = "name";
	public static final String TAG_ARRAY = "array";
	public static final String TAG_FIELD = "field";
	public static final String TAG_LIST = "list";
	public static final String TAG_MAP = "map";
	public static final String TAG_NULL = "null";
	public static final String TAG_OBJECT = "object";
	public static final String TAG_SET = "set";
	public static final String UTF8ENCODING = "UTF-8";

	private XmlObjConverter() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			factoryT = TransformerFactory.newInstance();
			builder = factory.newDocumentBuilder();
			trans = factoryT.newTransformer();
			trans.setOutputProperty(OutputKeys.ENCODING, UTF8ENCODING);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static XmlObjConverter getInstance() {
		if (instance == null) {
			instance = new XmlObjConverter();
		}
		return instance;
	}

	public String object2Xml(Object obj) throws ConverterException {

		try {
			Document dom = builder.newDocument();
			dom.appendChild(obj2Element(dom, obj, null));

			StreamResult result = new StreamResult(new ByteArrayOutputStream());
			DOMSource source = new DOMSource(dom);
			trans.transform(source, result);

			return result.getOutputStream().toString();

		} catch (Exception e) {
			throw new ConverterException(obj.getClass(), e.getCause() );
		}

	}

	public Object xml2Object(String xml) throws ConverterException {
		ByteArrayInputStream is = new ByteArrayInputStream(xml.getBytes());
		try {
			Document dom = builder.parse(is);

			Object obj = element2Obj((Element) dom.getChildNodes().item(0));

			return obj;

		} catch (Exception e) {
			throw new ConverterException(xml, e.getCause() );
		}

	}

	private Element obj2Element(Document dom, Object obj, String name)
			throws DOMException, IllegalArgumentException,
			IllegalAccessException {

		Element node;
		if (obj == null) {
			node = dom.createElement(TAG_NULL);
			if (name != null) {
				node.setAttribute(ATTR_NAME, name);
			}
			return node;
		}

		Class<?> clazz = obj.getClass();
		if (clazz.isArray()) {

			node = arrayObj2Element(dom, obj, clazz, name);

		} else if (List.class.isAssignableFrom(clazz)) {

			node = listObj2Element(dom, obj, clazz, name);

		} else if (Set.class.isAssignableFrom(clazz)) {

			node = setObj2Element(dom, obj, clazz, name);

		} else if (Map.class.isAssignableFrom(clazz)) {

			node = mapObj2Element(dom, obj, clazz, name);

		} else {
			node = normalObj2Element(dom, obj, clazz, name);
		}

		return node;
	}

	private Element normalObj2Element(Document dom, Object obj, Class<?> clazz,
			String name) throws DOMException, IllegalArgumentException,
			IllegalAccessException {
		Element node = dom.createElement(TAG_OBJECT);
		node.setAttribute(ATTR_CLASS, clazz.getName());
		if (name != null) {
			node.setAttribute(ATTR_NAME, name);
		}

		for(; clazz != Object.class ; clazz = clazz.getSuperclass()) {  
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				if (Modifier.isStatic(field.getModifiers())
						|| Modifier.isFinal(field.getModifiers())) {
					continue;
				}
				if (!field.isAccessible()) {
					field.setAccessible(true);
				}
				Object subobj = field.get(obj);
				if (subobj == null || isPlainType(field.getType(), subobj)) {
					node.appendChild(plainObj2Element(dom, subobj, field.getName()));
				} else {
					node.appendChild(obj2Element(dom, subobj, field.getName()));
				}
			}
		}

		return node;
	}

	private Element arrayObj2Element(Document dom, Object obj, Class<?> clazz,
			String name) throws DOMException, IllegalArgumentException,
			IllegalAccessException {
		Element node = dom.createElement(TAG_ARRAY);
		if (name != null) {
			node.setAttribute(ATTR_NAME, name);
		}
		node.setAttribute(ATTR_COMPONENT, clazz.getComponentType().getName());
		for (int i = 0; i < Array.getLength(obj); i++) {
			Object subobj = Array.get(obj, i);
			if (subobj == null || isPlainType(clazz.getComponentType(), subobj)) {
				node.appendChild(plainObj2Element(dom, subobj, null));
			} else {
				node.appendChild(obj2Element(dom, subobj, null));
			}
		}

		return node;
	}

	private Element listObj2Element(Document dom, Object obj, Class<?> clazz,
			String name) throws DOMException, IllegalArgumentException,
			IllegalAccessException {
		Element node = dom.createElement(TAG_LIST);
		if (name != null) {
			node.setAttribute(ATTR_NAME, name);
		}
		node.setAttribute(ATTR_CLASS, clazz.getName());
		String tmpClazz = null;
		for (Object subobj : (List<?>) obj) {
			if (subobj == null || isPlainType(subobj.getClass(), subobj)) {
				node.appendChild(plainObj2Element(dom, subobj, null));
				if (subobj != null) {
					tmpClazz = subobj.getClass().getName();
				}
			} else {
				node.appendChild(obj2Element(dom, subobj, null));
				tmpClazz = subobj.getClass().getName();
			}
		}
		if (tmpClazz != null) {
			node.setAttribute(ATTR_COMPONENT, tmpClazz);
		}

		return node;
	}

	private Element setObj2Element(Document dom, Object obj, Class<?> clazz,
			String name) throws DOMException, IllegalArgumentException,
			IllegalAccessException {
		Element node = dom.createElement(TAG_SET);
		if (name != null) {
			node.setAttribute(ATTR_NAME, name);
		}
		node.setAttribute(ATTR_CLASS, clazz.getName());
		String tmpClazz = null;
		for (Object subobj : (Set<?>) obj) {
			if (subobj == null || isPlainType(subobj.getClass(), subobj)) {
				node.appendChild(plainObj2Element(dom, subobj, null));
				if (subobj != null) {
					tmpClazz = subobj.getClass().getName();
				}
			} else {
				node.appendChild(obj2Element(dom, subobj, null));
				tmpClazz = subobj.getClass().getName();
			}
		}
		if (tmpClazz != null) {
			node.setAttribute(ATTR_COMPONENT, tmpClazz);
		}

		return node;
	}

	private Element mapObj2Element(Document dom, Object obj, Class<?> clazz,
			String name) throws DOMException, IllegalArgumentException,
			IllegalAccessException {
		Element node = dom.createElement(TAG_MAP);
		if (name != null) {
			node.setAttribute(ATTR_NAME, name);
		}
		node.setAttribute(ATTR_CLASS, clazz.getName());
		String keyClazz = null;
		String valueClazz = null;
		for (Entry<?, ?> subobj : ((Map<?, ?>) obj).entrySet()) {
			if (subobj.getKey() == null
					|| isPlainType(subobj.getKey().getClass(), subobj.getKey())) {
				node.appendChild(plainObj2Element(dom, subobj.getKey(), null));
				if (subobj.getKey() != null) {
					keyClazz = subobj.getKey().getClass().getName();
				}
			} else {
				node.appendChild(obj2Element(dom, subobj.getKey(), null));
				keyClazz = subobj.getKey().getClass().getName();
			}
			if (subobj.getValue() == null
					|| isPlainType(subobj.getValue().getClass(),
							subobj.getValue())) {
				node.appendChild(plainObj2Element(dom, subobj.getValue(), null));
				if (subobj.getValue() != null) {
					valueClazz = subobj.getValue().getClass().getName();
				}
			} else {
				node.appendChild(obj2Element(dom, subobj.getValue(), null));
				valueClazz = subobj.getValue().getClass().getName();
			}
		}
		if (keyClazz != null && valueClazz != null) {
			node.setAttribute(ATTR_COMPONENT, keyClazz);
			node.setAttribute(ATTR_COMPONENT1, valueClazz);
		}

		return node;
	}
	
	private Element plainObj2Element(Document dom, Object obj, String name) {
		Element node;
		if (obj == null) {
			node = dom.createElement(TAG_NULL);
		} else {
			node = dom.createElement(TAG_FIELD);
			if( obj instanceof Date ) {
				node.setTextContent(sdf.format(obj));
			} else {
				node.setTextContent(obj.toString());
			}
		}
		if (name != null) {
			node.setAttribute(ATTR_NAME, name);
		}
		return node;
	}

	private boolean isPlainType(Class<?> clazz, Object obj) {
		if (clazz.isPrimitive()) {
			return true;
		} else if (Byte.class.isAssignableFrom(clazz)) {
			return true;
		} else if (Boolean.class.isAssignableFrom(clazz)) {
			return true;
		} else if (Character.class.isAssignableFrom(clazz)) {
			return true;
		} else if (Double.class.isAssignableFrom(clazz)) {
			return true;
		} else if (Float.class.isAssignableFrom(clazz)) {
			return true;
		} else if (Integer.class.isAssignableFrom(clazz)) {
			return true;
		} else if (Long.class.isAssignableFrom(clazz)) {
			return true;
		} else if (Short.class.isAssignableFrom(clazz)) {
			return true;
		} else if (String.class.isAssignableFrom(clazz)) {
			return true;
		} else if (Void.class.isAssignableFrom(clazz)) {
			return true;
		} else if (Date.class.isAssignableFrom(clazz)) {
			return true;
		} else if (Enum.class.isAssignableFrom(clazz)) {
			return true;
		}
		return false;
	}

	private Object element2Obj(Element node) throws Exception {

		Object obj = null;
		String tagName = node.getTagName();
		String clazzName = node.getAttribute(ATTR_CLASS);
		Class<?> clazz = name2Class(clazzName);

		if (tagName.equals(TAG_ARRAY)) {

			obj = element2ArrayObj(node, clazz);

		} else if (tagName.equals(TAG_LIST)) {

			obj = element2ListObj(node, clazz);

		} else if (tagName.equals(TAG_SET)) {

			obj = element2SetObj(node, clazz);

		} else if (tagName.equals(TAG_MAP)) {

			obj = element2MapObj(node, clazz);

		} else {
			obj = element2NormalObj(node, clazz);
		}

		return obj;
	}

	private Object element2NormalObj(Element node, Class<?> clazz)
			throws Exception {
		Object obj = generateNewInstance(clazz);
		NodeList nodelist = node.getChildNodes();
		for (int i = 0; i < nodelist.getLength(); i++) {
			Element subNode = (Element) nodelist.item(i);
			String fieldName = subNode.getAttribute(ATTR_NAME);
			
			Field field = null;
			for(; clazz != Object.class ; clazz = clazz.getSuperclass()) {  
	            try {  
	                field = clazz.getDeclaredField(fieldName) ;  
	                break;  
	            } catch (Exception e) {}   
	        }
			if( field == null ) {
				continue;
			}
			if (!field.isAccessible()) {
				field.setAccessible(true);
			}
			if (subNode.getTagName().equals(TAG_FIELD)) {
				field.set( obj, string2PlainObj(subNode.getTextContent(),
								field.getType(), false));
			} else if ( subNode.getTagName().equals(TAG_NULL)) {
				field.set(
						obj, string2PlainObj(subNode.getTextContent(),
								field.getType(), true));
			} else {
				field.set(obj, element2Obj(subNode));
			}
		}

		return obj;
	}

	private Object element2ArrayObj(Element node, Class<?> clazz)
			throws Exception {
		String componentClazzName = node.getAttribute(ATTR_COMPONENT);
		Class<?> componentClazz = name2Class(componentClazzName);
		NodeList nodelist = node.getChildNodes();
		Object obj = Array.newInstance(componentClazz, nodelist.getLength());
		for (int i = 0; i < nodelist.getLength(); i++) {
			Element subNode = (Element) nodelist.item(i);
			if (subNode.getTagName().equals(TAG_FIELD)) {
				Object subObj = string2PlainObj(subNode.getTextContent(),
						componentClazz, false);
				Array.set(obj, i, subObj);
			} else {
				Object subObj = element2Obj(subNode);
				Array.set(obj, i, subObj);
			}
		}

		return obj;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Object element2ListObj(Element node, Class<?> clazz)
			throws Exception {
		String componentClazzName = node.getAttribute(ATTR_COMPONENT);
		Class<?> componentClazz = name2Class(componentClazzName);
		Object obj = generateNewInstance(clazz);
		NodeList nodelist = node.getChildNodes();
		for (int i = 0; i < nodelist.getLength(); i++) {
			Element subNode = (Element) nodelist.item(i);
			if (subNode.getTagName().equals(TAG_FIELD)) {
				((List) obj).add(string2PlainObj(subNode.getTextContent(),
						componentClazz, false));
			} else {
				((List) obj).add(element2Obj(subNode));
			}
		}

		return obj;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Object element2SetObj(Element node, Class<?> clazz)
			throws Exception {
		String componentClazzName = node.getAttribute(ATTR_COMPONENT);
		Class<?> componentClazz = name2Class(componentClazzName);
		Object obj = generateNewInstance(clazz);
		NodeList nodelist = node.getChildNodes();
		for (int i = 0; i < nodelist.getLength(); i++) {
			Element subNode = (Element) nodelist.item(i);
			if (subNode.getTagName().equals(TAG_FIELD)) {
				((Set) obj).add(string2PlainObj(subNode.getTextContent(),
						componentClazz, false));
			} else {
				((Set) obj).add(element2Obj(subNode));
			}
		}

		return obj;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Object element2MapObj(Element node, Class<?> clazz)
			throws Exception {
		String componentClazzName = node.getAttribute(ATTR_COMPONENT);
		Class<?> componentClazz = name2Class(componentClazzName);
		String componentClazzName1 = node.getAttribute(ATTR_COMPONENT1);
		Class<?> componentClazz1 = name2Class(componentClazzName1);
		Object obj = generateNewInstance(clazz);
		NodeList nodelist = node.getChildNodes();
		for (int i = 0; i < nodelist.getLength(); i += 2) {
			Element keyNode = (Element) nodelist.item(i);
			Element valueNode = (Element) nodelist.item(i + 1);
			Object keyObj;
			Object valueObj;
			if (keyNode.getTagName().equals(TAG_FIELD)) {
				keyObj = string2PlainObj(keyNode.getTextContent(),
						componentClazz, false);
			} else {
				keyObj = element2Obj(keyNode);
			}
			if (valueNode.getTagName().equals(TAG_FIELD)) {
				valueObj = string2PlainObj(valueNode.getTextContent(),
						componentClazz1, false);
			} else {
				valueObj = element2Obj(valueNode);
			}
			((Map) obj).put(keyObj, valueObj);
		}

		return obj;
	}

	private Class<?> name2Class(String name) throws ClassNotFoundException {
		if (name.equals("")) {
			return null;
		} else if (name.equals(boolean.class.getName())) {
			return boolean.class;
		} else if (name.equals(byte.class.getName())) {
			return byte.class;
		} else if (name.equals(char.class.getName())) {
			return char.class;
		} else if (name.equals(double.class.getName())) {
			return double.class;
		} else if (name.equals(float.class.getName())) {
			return float.class;
		} else if (name.equals(int.class.getName())) {
			return int.class;
		} else if (name.equals(long.class.getName())) {
			return long.class;
		} else if (name.equals(short.class.getName())) {
			return short.class;
		} else if (name.equals(void.class.getName())) {
			return void.class;
		} else {
			return Class.forName(name);
		}
	}

	private Object generateNewInstance(Class<?> type) throws Exception {
		Object obj = null;
		;
		Throwable throwable = null;
		if (type.isMemberClass()) {
			Class<?> outerClass = type.getDeclaringClass();
			Constructor<?> c = null;
			try {
				c = type.getDeclaredConstructor();
				if (!c.isAccessible()) {
					c.setAccessible(true);
				}
				obj = c.newInstance();
			} catch (Exception e) {
				try {
					c = type.getDeclaredConstructor(outerClass);
					if (!c.isAccessible()) {
						c.setAccessible(true);
					}
					obj = c.newInstance(outerClass.newInstance());
				} catch (Exception e1) {
					throwable = e.getCause();
				}
			}
		} else {
			try {
				obj = type.newInstance();
			} catch (Exception e) {
				e.printStackTrace();
				throwable = e.getCause();
			}
		}
		if (obj == null) {
			throw new Exception("Can not generate new instance with "
					+ type.getName(), throwable);
		}
		return obj;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Object string2PlainObj(String value, Class<?> type, boolean isNull)
			throws ParseException {
		if (type.equals(boolean.class)) {
			return Boolean.parseBoolean(value);
		} else if (type.equals(byte.class)) {
			return Byte.parseByte(value);
		} else if (type.equals(char.class)) {
			return value.charAt(0);
		} else if (type.equals(double.class)) {
			return Double.parseDouble(value);
		} else if (type.equals(float.class)) {
			return Float.parseFloat(value);
		} else if (type.equals(int.class)) {
			return Integer.parseInt(value);
		} else if (type.equals(long.class)) {
			return Long.parseLong(value);
		} else if (type.equals(short.class)) {
			return Short.parseShort(value);
		} else {
			if( isNull ) {
				return null;
			} else if (type.equals(Boolean.class)) {
				return Boolean.valueOf(value);
			} else if (type.equals(Byte.class)) {
				return Byte.valueOf(value);
			} else if (type.equals(Character.class)) {
				return new Character(value.charAt(0));
			} else if (type.equals(Double.class)) {
				return Double.valueOf(value);
			} else if (type.equals(Float.class)) {
				return Float.valueOf(value);
			} else if (type.equals(Integer.class)) {
				return Integer.valueOf(value);
			} else if (type.equals(Long.class)) {
				return Long.valueOf(value);
			} else if (type.equals(Short.class)) {
				return Short.valueOf(value);
			} else if (type.equals(String.class)) {
				return value;
			} else if (Date.class.isAssignableFrom(type)) {
				return sdf.parse(value);
			} else if (List.class.isAssignableFrom(type)) {
				return value;
			} else if (Map.class.isAssignableFrom(type)) {
				return value;
			} else if (Set.class.isAssignableFrom(type)) {
				return value;
			} else if (Enum.class.isAssignableFrom(type)) {
				return Enum.valueOf((Class<Enum>)type, value);
			}
		}
		return null;
	}
	
}