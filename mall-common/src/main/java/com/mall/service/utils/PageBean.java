package com.mall.service.utils;

import java.util.List;

public class PageBean<T> {

        private int currentPage = 1;//当前页，默认显示第一页
        private int pageCount = 4;//每页显示的行数（查询返回的行数），默认每页显示3行
        private int totalCount ;//数据库表中的总记录数
        private int totalPage;//总页数  =  总记录数  /    每页显示的行数（+1）
        private List<T> list; //分页查询到的数据

        //返回总页数
        public int getTotalPage() {

        //若总页数是奇数是页数增加的逻辑判断

        if(totalCount % pageCount == 0){
        totalPage = totalCount / pageCount;
        }else{
        totalPage = totalCount / pageCount +1;
        }

        return totalPage;
        }

        public int getCurrentPage() {
        return currentPage;
        }

        public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        }

        public int getPageCount() {
        return pageCount;
        }

        public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
        }

        public int getTotalCount() {

        return totalCount;
        }

        public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        }



        public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
        }

        public List<T> getList() {
        return list;
        }

        public void setList(List<T> list) {
        this.list = list;
        }
}
