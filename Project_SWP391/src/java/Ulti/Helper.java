/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ulti;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author admin
 */
public class Helper {
    public static List pagination(List list,int pageNum,int size){
        if(list == null || list.isEmpty()){
            return Collections.EMPTY_LIST;
        }
        return list.subList((pageNum - 1) * size, Math.min(list.size(), size * pageNum));
    }
}
