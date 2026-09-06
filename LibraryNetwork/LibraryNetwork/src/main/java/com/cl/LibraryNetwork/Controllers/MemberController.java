package com.cl.LibraryNetwork.Controllers;

import com.cl.LibraryNetwork.Entities.Member;
import com.cl.LibraryNetwork.Services.MemberService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping
    public List<Member> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Member getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Member create(@RequestBody Member entity) { return service.save(entity); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}