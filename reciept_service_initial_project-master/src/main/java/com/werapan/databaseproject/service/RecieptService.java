/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.werapan.databaseproject.service;

import com.werapan.databaseproject.dao.RecieptDao;
import com.werapan.databaseproject.dao.RecieptDetailDao;
import com.werapan.databaseproject.model.Reciept;
import com.werapan.databaseproject.model.RecieptDetail;
import java.util.List;

/**
 *
 * @author werapan
 */
public class RecieptService {

    public Reciept getById(int id){
        RecieptDao recieptDao = new RecieptDao();
        return recieptDao.get(id);
    }
    
    public List<Reciept> getReciepts(){
        RecieptDao recieptDao = new RecieptDao();
        return recieptDao.getAll(" reciept_id asc");
    }

    public Reciept addNew(Reciept editedReciept) {
        RecieptDao recieptDao = new RecieptDao();
        RecieptDetailDao recieptDetailDao = new RecieptDetailDao();
        Reciept reciept = recieptDao.save(editedReciept);
        for(RecieptDetail rd : editedReciept.getRecieptDeatails()){
            rd.setRecieptId(reciept.getId());
            recieptDetailDao.save(rd);
        }
        return reciept;
    }

    public Reciept update(Reciept editedReciept) {
        RecieptDao recieptDao = new RecieptDao();
        return recieptDao.update(editedReciept);
    }

    public int delete(Reciept editedReciept) {
        RecieptDao recieptDao = new RecieptDao();
        return recieptDao.delete(editedReciept);
    }
}
