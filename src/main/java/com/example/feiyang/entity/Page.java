package com.example.feiyang.entity;

/**
 * @ProjectName: feiyang
 * @Author: lyl
 * @Date: 2022-05-19 10:30
 **/

public class Page {
    private int current = 1;
    private int limit = 8;
    //数据总数，用于计算总页数
    private int rows;


    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current>=1){
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit>0 && limit<=100){
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows>0){
            this.rows = rows;
        }
    }


    /**
     * 前端只会传入当前页的页码，需要根据当前页页码算出起始行
     * @return
     */
    public int getOffset(){
        return (current-1)*limit;
    }

    /**
     * 获取总页数
     * @return
     */
    public int getTotal(){
        if(rows%limit == 0){
            return rows/limit;
        }else{
            return rows/limit+1;
        }
    }


}
