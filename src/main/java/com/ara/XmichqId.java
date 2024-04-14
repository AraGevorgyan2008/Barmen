package com.ara;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class XmichqId {
    private String id ;
    private int[] arr;
    private String pel_id ;
    private int num ;
    private String url ;

    public XmichqId(String id, String pel_id, int num, String url) {
        this.id = id;
        this.pel_id = pel_id;
        this.num = num;
        this.url = url;
    }
    public XmichqId(int[] arr, String pel_id, int num, String url) {
        this.id = id;
        this.pel_id = pel_id;
        this.num = num;
        this.url = url;
    }
}
