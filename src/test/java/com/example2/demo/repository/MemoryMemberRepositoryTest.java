package com.example2.demo.repository;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example2.demo.domain.Member;

public class MemoryMemberRepositoryTest {
    
    MemoryMemberRepository repository = new MemoryMemberRepository();
    
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member, result);
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member mem1 = new Member();
        mem1.setName("resp1");
        repository.save(mem1);

        Member mem2 = new Member();
        mem2.setName("resp2");
        repository.save(mem2);

        Member result = repository.findByName("resp2").get();
        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(mem2);

    }

    @Test
    public void findAll(){
        Member mem1 = new Member();
        mem1.setName("111");
        repository.save(mem1);

        Member mem2 = new Member();
        mem1.setName("222");
        repository.save(mem2);

        List<Member> result = repository.findAll();
         org.assertj.core.api.Assertions.assertThat(result.size()).isEqualTo(2);

    }
}

