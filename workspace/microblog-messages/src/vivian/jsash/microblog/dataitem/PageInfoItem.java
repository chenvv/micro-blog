package vivian.jsash.microblog.dataitem;

public class PageInfoItem {
	
	private int pageSize;
	private int pageCount;
	
	public PageInfoItem() { 
	}
	
	public PageInfoItem( int pagecount, int pagesize ) {
		pageSize =  pagesize;
		pageCount =  pagecount;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	public int getPageCount() {
		return pageCount;
	}
	
}
