package vivian.jsash.kernal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjXmlTester {
	private int aa;
	private long bb;
	private double cc;
	private char dd;
	private List<Integer> list;
	private Map<String, Double> map;
	private int[] aaaa;
	private Long[] bbbb;
	private String cccc;
	private Date dddd;
	private double[][] eeee;
	private InnerClass ffff;
	private InnerClass gggg;
	private ENUM_TEST hhhh;
	private enum ENUM_TEST {
		AAA,
		BBB
	}
	
	private class InnerClass {
		private String[] abcd;
		
		public void init() {
			abcd = new String[]{ "aaa", "bbb" };
		}
		
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("{abcd:[");
			for( int i=0; i<abcd.length; i++ ) {
				sb.append( abcd[i] );
				if( i<abcd.length-1 )
					sb.append(",");
			}
			sb.append("]}");
			return sb.toString();
		}
	}
	
	public void init() {
		aa = 0;
		bb = 1;
		cc = 1.1;
		dd = 'a';
		list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		map = new HashMap<String, Double>();
		map.put("aaa", 1.1);
		map.put("bbb", 1.2);
		aaaa = new int[]{1,2,3,4};
		bbbb = new Long[]{};
		cccc = "Hello world";
		Calendar c = Calendar.getInstance();
		c.set(2010, 01, 01, 0, 0, 0);
		dddd = new Date( c.getTimeInMillis() );
		eeee = new double[][]{{1,2},{3,4}};
		ffff = new InnerClass();
		ffff.init();
		gggg = null;
		hhhh = ENUM_TEST.BBB;
	}
	
	public String toString() {
		StringBuffer sb  = new StringBuffer();
		sb.append("aa=").append(aa).append("\n");
		sb.append("bb=").append(bb).append("\n");
		sb.append("cc=").append(cc).append("\n");
		sb.append("dd=").append(dd).append("\n");
		sb.append("list=").append(list).append("\n");
		sb.append("map=").append(map).append("\n");
		sb.append("aaaa=").append(Arrays.toString(aaaa)).append("\n");
		sb.append("bbbb=").append(Arrays.toString(bbbb)).append("\n");
		sb.append("cccc=").append(cccc).append("\n");
		sb.append("dddd=").append(dddd).append("\n");
		sb.append("eeee={");
		for( int i=0; i<eeee.length; i++ ) {
			sb.append(Arrays.toString(eeee[i]));
			if( i<eeee.length-1 )
				sb.append(",");
		}
		sb.append("}\n");
		sb.append("ffff=").append(ffff).append("\n");
		sb.append("gggg=").append(gggg).append("\n");
		sb.append("hhhh=").append(hhhh).append("\n");
		return sb.toString();
	}

	public static void main(String[] args) {
		try {
			ObjXmlTester test = new ObjXmlTester();
			test.init();
			
			System.out.println(test);
			
			XmlObjConverter converter = XmlObjConverter.getInstance();
			String xml = converter.object2Xml(test);
			
			System.out.println(xml);
			
			Object obj = converter.xml2Object(xml);
			
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
