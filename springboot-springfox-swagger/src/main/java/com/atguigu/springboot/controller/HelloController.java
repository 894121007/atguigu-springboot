package com.atguigu.springboot.controller;

import com.atguigu.springboot.entities.Pet;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/30 14:33
 *
 */
@RestController
@RequestMapping("/")
public class HelloController {

	@ApiOperation(value = "查询方法")
	@GetMapping(value = "helloworld",params = {"status"})
	public String helloworld(@ApiParam
								 @RequestParam(value = "status",
										 defaultValue="${SomeController.findPetsByStatus.status.default}") String status) {
		return "abc";
	}

	@ApiOperation(value = "Find pet by Status",
			notes = "${SomeController.findPetsByStatus.notes}")
	@RequestMapping(value = "/findByStatus", method = RequestMethod.GET, params = {"status"})
	public Pet findPetsByStatus(
			@ApiParam(value = "${SomeController.findPetsByStatus.status}",
					required = true)
			@RequestParam(value = "status",
					defaultValue="${SomeController.findPetsByStatus.status.default}") String status) {

		Pet pet = new Pet();
		pet.setName("佩奇");
		pet.setWeight(50.0);
		return pet;
	}

	@ApiOperation(notes = "Operation 2", value = "${SomeController.operation2.value}")
	@ApiImplicitParams(
			@ApiImplicitParam(name="header1", value="${SomeController.operation2.header1}")
	)
	@RequestMapping(value = "operation2", method = RequestMethod.POST)
	public ResponseEntity<String> operation2() {
		return ResponseEntity.ok("");
	}
}
