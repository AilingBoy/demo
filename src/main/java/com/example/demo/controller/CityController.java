package com.example.demo.controller;

import com.example.demo.domain.City;
import com.example.demo.result.JsonResult;
import com.example.demo.service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Api(value = "城市",tags = "城市管理")
public class CityController {
    @Autowired
    private CityService cs;

    private static final Logger logger= LoggerFactory.getLogger(CityController.class);
    @ApiOperation("列表展示")
    @GetMapping(value = {"/city", "/"})
    public JsonResult findAll(@RequestParam(value = "pageSize",required = false)Integer pageSize,
                              @RequestParam(value = "pageNum",required = false)Integer pageNum) {
        List<City> list = cs.findAll();
        return JsonResult.data(list);
    }

    @ApiOperation("查询city")
    @GetMapping(value = "/city/{id}")
    public JsonResult findById(@PathVariable String id, Model model) {
        City city = cs.findById(id);
        return JsonResult.data(city);
    }

    @ApiOperation("添加city")
    //    @PostMapping("/city")
    @RequestMapping(value = "/city", method = RequestMethod.POST)
    public JsonResult updateCity(City city) {
        return JsonResult.data(cs.insertCity(city));
    }

    @ApiOperation("修改city")
    @PutMapping("/city")
    public JsonResult update(City city) {
        return JsonResult.data(cs.updateById(city));
    }

    @ApiOperation("删除city")
    @DeleteMapping("/city/{id}")
    public JsonResult delete(@PathVariable("id") String id) {
        return JsonResult.data(cs.deleteById(id));
    }

}
