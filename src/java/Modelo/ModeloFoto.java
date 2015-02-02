/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import hibernate.Foto;
import hibernate.Inmueble;
import hibernate.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Antonio
 */
public class ModeloFoto{
public static List<Foto> get() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Foto";
        Query q = session.createQuery(hql);
        List<Foto> fotos = q.list();
        session.getTransaction().commit();
        session.close();
        return fotos;
    }

    public static Foto get(String id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Foto f = (Foto) session.get(Foto.class, Integer.parseInt(id));
        session.getTransaction().commit();
        session.close();
        return f;
    }

    public static void delete(String id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Foto i = (Foto) session.load(Foto.class, Integer.parseInt(id));
        session.delete(i);
        session.getTransaction().commit();
        session.flush();
        session.close();
    }

    public static void insert(Foto i) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(i);
        session.getTransaction().commit();
        session.flush();
        session.close();
    }

    public static void edit(Foto i) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(i);
        session.getTransaction().commit();
        session.flush();
        session.close();
    }

}