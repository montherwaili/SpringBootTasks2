package com.cl.LibraryNetwork.Controllers;


import com.cl.LibraryNetwork.Entities.Member;
import com.cl.LibraryNetwork.Services.MemberService;
import com.cl.LibraryNetwork.dto.MemberDTO;
import com.cl.LibraryNetwork.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberMapper memberMapper;

    @PostMapping
    public MemberDTO createMember(@RequestBody Member member) {
        return memberMapper.convertToDTO(memberService.save(member));
    }

    @GetMapping
    public List<MemberDTO> getAllMembers() {
        return memberMapper.convertToDTO(memberService.findAll());
    }

    @GetMapping("/{id}")
    public MemberDTO getMemberById(@PathVariable Long id) {
        return memberMapper.convertToDTO(memberService.findById(id));
    }

    @PutMapping("/{id}")
    public MemberDTO updateMember(@PathVariable Long id, @RequestBody Member member) {
        member.setId(id);
        return memberMapper.convertToDTO(memberService.save(member));
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteById(id);
    }
}