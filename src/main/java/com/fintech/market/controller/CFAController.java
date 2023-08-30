package com.fintech.market.controller;

import com.fintech.market.dto.CFAView;
import com.fintech.market.entity.CFA;
import com.fintech.market.model.CFAModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cfa")
public class CFAController {
    private final CFAModel cfaModel;

    public CFAController(CFAModel cfaModel) {
        this.cfaModel = cfaModel;
    }

    @PostMapping("/create")
    public CFAView create(@RequestBody CFAView cfa) {
        return cfaModel.create(cfa);
    }

    @PostMapping("/{id}")
    public CFAView get(@PathVariable("id") CFA cfaEntity) {
        return cfaModel.get(cfaEntity);
    }
}
