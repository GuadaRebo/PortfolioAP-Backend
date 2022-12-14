
package com.portfolio.API.controller;

import com.portfolio.API.model.ExpLaboral;
import com.portfolio.API.service.IExpLaboralService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = {"https://ap-portfoliofront.web.app/"})
public class ExpLaboralController {
    @Autowired
    private IExpLaboralService explabServ;
    
    @GetMapping ("/explaboral/ver")
    @ResponseBody
    public List<ExpLaboral> verExpLaboral () {
        return explabServ.verExpLaboral();
    }
    
    @PostMapping ("/explaboral/nueva")
    public void agregarExpLaboral (@RequestBody ExpLaboral explaboral) {
       explabServ.crearExpLaboral(explaboral);
    }
    
    @DeleteMapping ("/explaboral/delete/{id}")
    public void borrarExpLaboral (@PathVariable Long id) {
        explabServ.borrarExpLaboral(id);        
    }
    
    @GetMapping ("/explaboral/{id}")
    @ResponseBody
    public ExpLaboral buscarExpLaboralPorId(@PathVariable Long id){
        return explabServ.buscarExpLaboral( id);
    }
    
    @PutMapping ("/explaboral")
    public void actualizarExpLaboral (@RequestBody ExpLaboral explaboral)   {
        explabServ.actualizarExpLaboral(explaboral);
    }
}
