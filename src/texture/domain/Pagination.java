package texture.domain;

import java.util.List;

public class Pagination<T> {

	/**
	 * һҳ����Ĭ��10��
	 */
	private int pageSize = 10;
	/**
	 * ��ǰҳ��
	 */
	private int pageNo;

	/**
	 * ��һҳ
	 */
	private int upPage;

	/**
	 * ��һҳ
	 */
	private int nextPage;
	/**
	 * һ���ж���������
	 */
	private long totalCount;

	/**
	 * һ���ж���ҳ
	 */
	private int totalPage;
	/**
	 * ���ݼ���
	 */
	private List<T> datas;

	/**
	 * ��ҳ��url
	 */
	private String pageUrl;

	/**
	 * ��ȡ��һ����¼λ��
	 * 
	 * @return
	 */
	public int getFirstResult() {
		return (this.getPageNo() - 1) * this.getPageSize();
	}

	/**
	 * ��ȡ����¼λ��
	 * 
	 * @return
	 */
	public int getLastResult() {
		return this.getPageNo() * this.getPageSize();
	}

	/**
	 * ����һ������ҳ
	 */
	public void setTotalPage() {
		this.totalPage = (int) ((this.totalCount % this.pageSize > 0) ? (this.totalCount / this.pageSize + 1)
				: this.totalCount / this.pageSize);
	}

	/**
	 * ���� ��һҳ
	 */
	public void setUpPage() {
		this.upPage = (this.pageNo > 1) ? this.pageNo - 1 : this.pageNo;
	}

	/**
	 * ������һҳ
	 */
	public void setNextPage() {
		this.nextPage = (this.pageNo == this.totalPage) ? this.pageNo : this.pageNo + 1;
	}

	public int getNextPage() {
		return nextPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getUpPage() {
		return upPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount2) {
		this.totalCount = totalCount2;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public Pagination(int pageNo, int pageSize, long totalCount2) {
		this.setPageNo(pageNo);
		this.setPageSize(pageSize);
		this.setTotalCount(totalCount2);
		this.init();
	}

	/**
	 * ��ʼ�������ҳ
	 */
	private void init() {
		this.setTotalPage();// ����һ��ҳ��
		this.setUpPage();// ������һҳ
		this.setNextPage();// ������һҳ
	}
}
