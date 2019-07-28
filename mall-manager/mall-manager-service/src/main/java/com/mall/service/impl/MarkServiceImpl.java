package com.mall.service.impl;

import com.mall.service.MarkService;
import com.mall.service.impl.markAndclass.dao.impl.Mark1DaoImpl;
import com.mall.service.impl.markAndclass.dao.impl.MarkDaoImpl;
import com.mall.service.markAndclass.IMarkDao;
import com.mall.service.markAndclass.Mark;
import com.mall.service.markAndclass.MarkDao;
import com.mall.service.utils.PageBean;

import java.sql.SQLException;
import java.util.List;

public class MarkServiceImpl implements MarkService {
    @Override
    public Mark selectMarkIdByNameService(String ppmch) throws SQLException {
        MarkDao dao=new MarkDaoImpl();
        return dao.selectMarkIdByName(ppmch);
    }

    @Override
    public Integer addMarkService(Mark mark) throws SQLException {
        MarkDao dao=new MarkDaoImpl();
        dao.addMark(mark);
        return 1;
    }

    @Override
    public Integer deleteMarkByIdService(String pp_id) throws SQLException {
        MarkDao dao = new MarkDaoImpl();
        dao.deleteMarkById(pp_id);
        return 1;
    }

    @Override
    public Integer updateMarkByIdService(Mark mark, String pp_id) throws SQLException {
        MarkDao dao = new MarkDaoImpl();
        dao.updateMarkById(mark,pp_id);
        return 1;
    }

    @Override
    public List<Mark> selectAllService() throws SQLException {
        MarkDao dao = new MarkDaoImpl();
        List<Mark> markList=null;
        markList=dao.selectAll();
        return markList;
    }

    @Override
    public List<Mark> selectMarkByIdService(String pp_id) throws SQLException {
        MarkDao dao=new MarkDaoImpl();
        List<Mark> mark=null;
        mark=dao.selectMarkById(pp_id);
        return mark;
    }

    @Override
    public Mark selectMarkNameByIdService(String pp_id) throws SQLException {
        MarkDao dao=new MarkDaoImpl();
        Mark mark=dao.selectMarkNameById(pp_id);
        return mark;
    }

    @Override
    public List<Mark> selectMarkByNameService(String ppmch) throws SQLException {
        MarkDao dao=new MarkDaoImpl();
        List<Mark> mark=null;
        mark=dao.selectMarkByName(ppmch);
        return mark;
    }

    @Override
    public void getAllService(PageBean<Mark> pageBean) throws SQLException {
        IMarkDao dao = new Mark1DaoImpl();
        dao.getAll(pageBean);
    }

    @Override
    public void getByPpmchService(PageBean<Mark> pageBean, String ppmch) throws SQLException {
        IMarkDao dao=new Mark1DaoImpl();
        dao.getByPpmch(pageBean,ppmch);
    }
}
