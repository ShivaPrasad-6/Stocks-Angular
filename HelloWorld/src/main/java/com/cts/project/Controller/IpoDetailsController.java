package com.cts.project.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.cts.project.dao.IpoDetailsRepository;
import com.cts.project.pojos.IpoDetails;

@RestController
@RequestMapping("/getAllIpoDetails")
public class IpoDetailsController {

	@Autowired

	private IpoDetailsRepository ipodetailsRepository;

	@RequestMapping

	public Iterable<IpoDetails> getAllIpoDetails() {

		return ipodetailsRepository.findAll();

	}

	@PostMapping("/saveIpoDetails")

	public IpoDetails saveIpoDetails(@RequestBody IpoDetails ipodetails) {

		System.out.println(ipodetails);

		ipodetailsRepository.save(ipodetails);

		return ipodetails;

	}

	@PutMapping("/updateIpoDetails/{ipoid}")

	public IpoDetails updateIpoDetails(@RequestBody IpoDetails ipodetails, @PathVariable("ipoid") Integer ipoid) {

		ipodetails.setIpoid(ipoid);

		System.out.println(ipodetails);

		ipodetailsRepository.save(ipodetails);

		return ipodetails;

	}

	@DeleteMapping("/deleteIpoDetails/{ipoid}")

	public Boolean deleteIpoDetails(@PathVariable("ipoid") Integer ipoid) {

		System.out.println(ipoid);

		Optional<IpoDetails> ipodetails = ipodetailsRepository.findById(ipoid);

		ipodetailsRepository.delete(ipodetails.get());

		return true;

	}

	@GetMapping("/findOneInAll2/{ipoid}")

	public IpoDetails findoneinall(@PathVariable("ipoid") Integer ipoid)

	{

		Optional<IpoDetails> ipodetails = ipodetailsRepository.findById(ipoid);

		return ipodetails.get();

	}

}
