package com.bakerysystem.controller;

import com.bakerysystem.repo.BakeryRepository;
import com.bakerysystem.repo.BreadRepository;
import com.bakerysystem.repo.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // lets MVC know this is a controller
public class ListController {

    // inject out repos
    @Autowired
    private IngredientRepository i_repo;
    @Autowired
    private BreadRepository br_repo;
    @Autowired
    private BakeryRepository ba_repo;

    // Create the controller com.bakerysystem.controller.ListController which shows the JSP /src/main/webapp/WEB-INF/views/list.jsp
    @RequestMapping("/list")
    public String showList(Model model) {
        model.addAttribute("bakeries", ba_repo.findAll()); //The model attribute which contains the list of bakeries should be called bakeries.
        model.addAttribute("breads", br_repo.findAll()); // model attr for list of bread entities
        model.addAttribute("ingredients", i_repo.findAll()); // model attr for list of ingredient entities
        return "list"; // the view should show list.jsp
    }

}
