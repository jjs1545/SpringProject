package com.example.myportal.paging;

import java.util.ArrayList;

public class Paging {
	int maxPost;			// �������� ǥ�õ� �Խù�  �ִ� ���� �� ���� �Խù� ����
	int firstPageNo;		// ù��° ������ ��ȣ
	int prevPageNo;			// ���� ������ ��ȣ
	int startPageNo;		// ���� ������
	int currentPageNo;		// ���� ������ ��ȣ
	int endPageNo;			// �� ������
	int nextPageNo;			// ���� ������ ��ȣ
	int finalPageNo;		// ������ ������ ��ȣ
	int numberOfRecords;	// ��ü ���ڵ� ��
	int sizeOfPage;			// �������� ������ ����(1,2,3,4,5)
	
	public Paging(int currentPageNo, int maxPost) {
		this.currentPageNo = currentPageNo;
		this.sizeOfPage = 5; //�⺻ �������� 5���� ǥ����
		this.maxPost = (maxPost != 0) ? maxPost : 10; 
		// �Խù� �ִ� ������ 0���� �ƴ϶��  ���� �Խù� ����(maxPost)�̰�, ���� �Խù����� 0����� 10��ǥ���̴�(10�� �׳� ������) => 3�׿�����
	}

	public int getmaxPost() {
		return maxPost;
	}

	public void setmaxPost(int maxPost) {
		this.maxPost = maxPost;
	}

	public int getFirstPageNo() {
		return firstPageNo;
	}

	public void setFirstPageNo(int firstPageNo) {
		this.firstPageNo = firstPageNo;
	}

	public int getPrevPageNo() {
		return prevPageNo;
	}

	public void setPrevPageNo(int prevPageNo) {
		this.prevPageNo = prevPageNo;
	}

	public int getStartPageNo() {
		return startPageNo;
	}

	public void setStartPageNo(int startPageNo) {
		this.startPageNo = startPageNo;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getEndPageNo() {
		return endPageNo;
	}

	public void setEndPageNo(int endPageNo) {
		this.endPageNo = endPageNo;
	}

	public int getNextPageNo() {
		return nextPageNo;
	}

	public void setNextPageNo(int nextPageNo) {
		this.nextPageNo = nextPageNo;
	}

	public int getFinalPageNo() {
		return finalPageNo;
	}

	public void setFinalPageNo(int finalPageNo) {
		this.finalPageNo = finalPageNo;
	}

	public int getNumberOfRecords() {
		return numberOfRecords;
	}

	public void setNumberOfRecords(int numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
	}

	// ����¡ ����
	public void makePaging() {	
		if(currentPageNo == 0)		// ���� �������� 0������ �̶��(�Խù��� 1���� ���ٸ�)
			setCurrentPageNo(1);	// ���� �������� CurrentPageNo�� ���� 1�� �����Ѵ�. (�⺻�� ����)
		
		if(numberOfRecords == 0)	// �Խñ��� 1���� ���°��
			return;					// �׳� ���� �� ���� ��ȯ�Ͽ� ����¡�� ǥ������ �ʴ´�.
		
		
		
		if(maxPost == 0)			// �������� ǥ�õǴ� �ִ� �Խù� ���� 0�����
			setmaxPost(10);			// �ִ� ǥ�õǴ� �Խù� ���� 10���� �����Ѵ�. (�⺻ �� ����)
		
		int finalPage = (numberOfRecords + (maxPost -1)) / maxPost;
		// �Խù��� 81���� ��� => (81 + (10-1))/10 = 9 =>��, �Խù��� 81���� �� 9������ ���� ǥ��
		
		if(currentPageNo > finalPage)		// 6���������� '����'��ư�� ������ 11�������� �̵��� �ؾ��ϴµ�, finalPage�� 9�� ���  
			setCurrentPageNo(finalPage);	// currentPageNo�� finalPage���� ũ�Ƿ� CurrentPageNo�� finalPage�� �����.
		
		if(currentPageNo < 0) 		// 3����������  '����'��ư�� ������ 5������ ������ -3�ε� �׷� �������� �������� �����Ƿ�
			currentPageNo = 1;		// ���� �������� 1�� �����Ѵ�.
		
		boolean isNowFirst = currentPageNo == 1 ? true : false; //���� ���ǿ����� ���� �������� 1�̸� true���� �ƴϸ� false���� isNowFirst�� �ִ´�.
		boolean isNowFinal = currentPageNo == finalPage ? true : false; //������������ ������ �������� ����(ex. 9������)��� true����, �ƴϸ� false���� isNowFinal�� �ִ´�. 
		
		int startPage = ((currentPageNo -1) / sizeOfPage) * sizeOfPage + 1;
		// ���� �������� 4�ϰ�� => ((4-1) / sizeOfPage(5)) * 5 +1 => 1�������� ù ������
		// ���� �������� 7�ϰ�� => ((7-1) / sizeOfPage(5)) * 5 +1 => 6�������� ù ������
		// ���� �������� 14�ϰ�� => ((14-1) / sizeOfPage(5)) * 5 +1 => 11�������� ù ������
		
		int endPage = startPage + sizeOfPage -1; 
		// ���� �������� 4�ϰ�� ù �������� 1 => 1 + 5 -1 => 5 �������� ��
		// ���� �������� 7�ϰ�� ù �������� 6 => 6 + 5 -1 => 10 �������� ��
		// ���� �������� 14�ϰ�� ù �������� 11 => 11 + 5 -1 =>15 �������� ��
		
		if(endPage > finalPage) // �Խù� ������ 81�� �̿��� finalPage�� 9�ε�, 1~5���������� '����'��ư�� ������ sizeOfPage ����������
			endPage = finalPage; // 5���� ǥ�ð� �Ǿ� �� 6~10������ �����ԵǴ� ������ �߻��Ѵ�. �׷��⿡ �Խù� ���� ���� finalPage������ ǥ��
								// �ϱ����� endPage��� ������ �����. ���� endPage�� ��� 10�� ǥ�õǾ���, 10�� ������ 9�������� �̵�.
		
		setFirstPageNo(1);			// FirstPageNo��� ������ 1�� ����
		
		if(!isNowFirst)
			setPrevPageNo(((startPage -1) < 1 ? 1 : (startPage -1))); // startPage(�ʱⰪ 1)�� 1���� ������ 1�������� ǥ���ϰ�, �װԾƴ϶�� ���������� -1�� ǥ��
																	  // ���� ��� 8�������� �ִ°�� ������ ������ �ʱ�������(6)���� -1�� �� 5�������� ǥ�õȴ�.
		setStartPageNo(startPage);		//���� ���ǵ�� �Ͽ� startPage�� ��! ���Ѵ�.
		setEndPageNo(endPage);			//���� ���ǵ�� �Ͽ� endPage�� ��! ���Ѵ�.
		
		if(!isNowFinal)					// isNowFinal�� ������������ �������������� �����Ѱ�� true, �ƴϸ� false�� ���� ����. 
			setNextPageNo(((endPage +1 > finalPage ? finalPage : (endPage +1))));
		// ���������� 17�������ε� ���� ���� 7�������� �������, '����'�� Ŭ���ϸ� ������ ���� ������ �����Ѵ�.
		// 7�������� �ִ� ����� ��(endPage)�������� 10�������̸�, �� 10�������� 1�� ���� ���� finalPage(17������)���� ũ�� finalPage��, �ƴϸ� ��(endPage)�������� +1���� 11�������� ǥ��.
		setFinalPageNo(finalPage);		// ������ ������ ��ȣ	
	}	
}