package com.example.blogReadMale.vo;

public class PagingVo {
	   private int total;
	   private int maxPage;   //total div
	   private int remains;   //total mod
	   
	   public PagingVo() {
	      
	   }

	   public PagingVo(int total, int maxPage, int remains) {
	      super();
	      this.total = total;
	      this.maxPage = maxPage;
	      this.remains = remains;
	   }

	   public int getTotal() {
	      return total;
	   }

	   public void setTotal(int total) {
	      this.total = total;
	   }

	   public int getMaxPage() {
	      return maxPage;
	   }

	   public void setMaxPage(int maxPage) {
	      this.maxPage = maxPage;
	   }

	   public int getRemains() {
	      return remains;
	   }

	   public void setRemains(int remains) {
	      this.remains = remains;
	   }

	   @Override
	   public String toString() {
	      return "PagingVo [total=" + total + ", maxPage=" + maxPage + ", remains=" + remains + "]";
	   }
	   
	   
	}
