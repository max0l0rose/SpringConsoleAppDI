package com.example.springconsoleappdi.controller;

import com.example.springconsoleappdi.services.MyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

public class Helper {

	public static <T> void getPage(Model model,
							   Map<String, Object> session,
							   MyService<T> service,
							   int pageNumber,
							   String sort,
							   String sortDir) {
		String ssort = (String) session.get("sort");
		if (sort.equals(""))
			sort = ssort;

		//assert null != null;

		if (sortDir.equals(""))
			sortDir = (sortDir = (String) session.get("sortDir")) != null ? sortDir : "";

		Integer pn = (Integer) session.get("pageNumber");

		if (!sort.equals(ssort))
			sortDir = "asc";
		else
			if (pn == null || pn == pageNumber)
				sortDir = sortDir.equals("asc") ? "desc" : "asc";

		Pageable pageable =
				PageRequest.of(pageNumber, 6,
						sortDir.equals("asc") ? Sort.by(sort).ascending() : Sort.by(sort).descending());
//				PageRequest.of(0, 5, Sort.by("price").descending().and(Sort.by("name")))
		Page<T> page = service.getPage(pageable);
		model.addAttribute("pageNumber", pageNumber);
		List list = page.getContent();
		model.addAttribute("list", list);
		model.addAttribute("totalElements", page.getTotalElements());
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("title", "INDEX");

		model.addAttribute("sort", sort);
		model.addAttribute("sortDir", sortDir);

		session.put("sort", sort);
		session.put("sortDir", sortDir);
		session.put("pageNumber", pageNumber);
	}
}
