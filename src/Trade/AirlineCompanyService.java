/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trade;

import DAO.AirlineCompanyDAO;
import Entities.AirlineCompany;
import Interfaces.IAirlineCompnayService;
import Transformers.AirlineT;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ElarbiMohamedAymen
 */
public class AirlineCompanyService implements IAirlineCompnayService{

    @Override
    public boolean Add(String name,String address) {
            AirlineCompanyDAO ACDAO = new AirlineCompanyDAO();
            AirlineCompany AirCompany = new AirlineCompany();
            if(ACDAO.checkexistance(name, address))
            {
                return false ;
            }
            AirCompany.setName(name);
            AirCompany.setAdresse(address);
            ACDAO.add(AirCompany);
            return true;
    }

    @Override
    public List<AirlineT> DisplayAll() {
         AirlineCompanyDAO pdao = new AirlineCompanyDAO();
        List <AirlineCompany> all = new ArrayList<>();
        List <AirlineT>AT = new ArrayList();
        all =  pdao.findAll();
        for(AirlineCompany X:all)
        {
            AirlineT PTP = new AirlineT(X.getCompanyId(), X.getAdresse(), X.getName());
            AT.add(PTP);
        }
        return AT;
    }

    @Override
    public List<AirlineT> FindByName(String name) {
        AirlineCompanyDAO ADAO = new AirlineCompanyDAO();
        List<AirlineCompany> Tmp = ADAO.findByNameList(name);
        List<AirlineT> TTmp = new ArrayList<>();
        for(AirlineCompany X:Tmp)
        {
            AirlineT PTP = new AirlineT(X.getCompanyId(), X.getName(), X.getAdresse());
            TTmp.add(PTP);
        }
        return TTmp;
    }
    
    @Override
    public boolean CheckUpdate(String name,String address,int id)
    {
            AirlineCompanyDAO ACDAO = new AirlineCompanyDAO();
            if(ACDAO.checkexistance(name, address))
            {
                return false ;
            }
            try
            {
                ACDAO.updateAdresse(id, address);
                ACDAO.updateName(id, name);   
            }
            catch(Exception E)
            {
                return false ;
            }

            return true;
    }

    @Override
    public boolean Delete(int id) {
        AirlineCompanyDAO ACDAO = new AirlineCompanyDAO();
        if(ACDAO.findById(id).getCompanyId()!=0)
        {
            ACDAO.removeById(id);
            return true;
        }
        return false ;

    }
    
    
    
    
    
    
    
}
