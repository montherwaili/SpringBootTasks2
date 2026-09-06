package com.cl.LibraryNetwork.Services;

import com.cl.LibraryNetwork.Entities.Member;
import com.cl.LibraryNetwork.Repositories.MemberRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberService {
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public List<Member> getAll() { return repository.findAll(); }
    public Member getById(Long id) { return repository.findById(id).orElse(null); }
    public Member save(Member entity) { return repository.save(entity); }

    public Member update(Long id, Member entity) {
        if (repository.existsById(id)) {
            entity.setId(id);
            return repository.save(entity);
        }
        return null;
    }

    public void delete(Long id) { repository.deleteById(id); }
}