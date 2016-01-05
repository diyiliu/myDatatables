package com.diyiliu.model;

import java.util.List;

/**
 * Description: TableData
 * Author: DIYILIU
 * Update: 2016-01-05 9:22
 */
public class TableData {

    private int draw;
    private List data;
    private int recordsTotal;
    private int recordsFiltered;

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }
}
