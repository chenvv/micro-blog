package vivian.jsash.microblog;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import vivian.jsash.microblog.dbmodel.dao.Account;
import vivian.jsash.microblog.dbmodel.dao.Blogs;
import vivian.jsash.microblog.dbmodel.dao.Event;
import vivian.jsash.microblog.dbmodel.dao.Follow;
import vivian.jsash.microblog.enums.EventTypeEnum;

public class EventProsessor {
	
	public static void processRepliedEvent( SessionFactory sf, int blogId ) {
		Session session = sf.openSession();
		Query query = session.createQuery("from " + Blogs.REF + " where " +	Blogs.PROP_ID + "=?" );
		query.setInteger(0, blogId );
		List<?> rs = query.list();
		if( rs != null && rs.size() > 0 ) {
			Blogs blog = (Blogs)rs.get(0);
			processEvent( session, EventTypeEnum.BlogReplied.ordinal(), blog.getCreateAccountId() );
		}
		session.close();
	}
	
	public static void processAtedEvent( SessionFactory sf, String atName ) {
		Session session = sf.openSession();
		Query query = session.createQuery("from "+Account.REF+" where "+Account.PROP_ACCOUNT_NAME+"=?");
		query.setString(0, atName );
		List<?> rs = query.list();
		if( rs != null && rs.size() > 0 ) {
			Account account = (Account)rs.get(0);
			processEvent( session, EventTypeEnum.BlogAtMe.ordinal(), account.getId() );
		}
		session.close();
	}
	
	public static void processPostedEvent( SessionFactory sf, int fromId) {
		Session session = sf.openSession();
		Query query = session.createQuery("from "+Follow.REF+" where " + Follow.PROP_FOLLOWED_ID + " =?");
		query.setInteger(0, fromId );
		List<?> rs = query.list();
		if( rs != null && rs.size() > 0 ) {
			for( Object obj : rs ) {
				Follow follow  = (Follow)obj;
				processEvent( session, EventTypeEnum.NewBlog.ordinal(), follow.getAccountId() );
			}
		}
		session.close();
	}

	public static void processfollowedEvent( SessionFactory sf, int toId ) {
		Session session = sf.openSession();
		processEvent( session, EventTypeEnum.NewFollowed.ordinal(), toId );
		session.close();
	}
	
	public static void processMessageEvent( SessionFactory sf, int toId ) {
		Session session = sf.openSession();
		processEvent( session, EventTypeEnum.NewMessage.ordinal(), toId );
		session.close();
	}
	
	public static void processFowardedEvent( SessionFactory sf, int blogId ) {
		Session session = sf.openSession();
		Query query = session.createQuery("from " + Blogs.REF + " where " +	Blogs.PROP_ID + "=?" );
		query.setInteger(0, blogId );
		List<?> rs = query.list();
		if( rs != null && rs.size() > 0 ) {
			Blogs blog = (Blogs)rs.get(0);
			processEvent( session, EventTypeEnum.BlogAtMe.ordinal(), blog.getCreateAccountId() );
		}
		session.close();
	}
	
	private static void processEvent( Session session, int type, int toId ) {
		Event event;
		
		Query query = session.createQuery("from " + Event.REF + " where " +	
				Event.PROP_ADDRESS_ID + "=? and " +	Event.PROP_EVENT_TYPE + "=?" );
		query.setInteger(0, toId );
		query.setInteger(1, type );
		List<?> rs = query.list();
		if( rs == null || rs.size() == 0 ) {
			event = new Event();
			event.setEventType( type );
			event.setEventQuantity(1);
			event.setAddressId( toId );
		} else {
			event = (Event) rs.get(0);
			event.setEventQuantity( event.getEventQuantity() + 1);
		}
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			if( event.getId()==null ) {
				session.save(event);
			} else {
				session.update(event);
			}
			tx.commit();
		} catch (Exception e ) { 
			if (tx != null) {
				tx.rollback();
			}
		}

	}
	
}
