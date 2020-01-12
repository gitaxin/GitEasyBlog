package cn.giteasy.blog.service.impl;

import cn.giteasy.blog.entity.Vote;
import cn.giteasy.blog.repository.VoteRepository;
import cn.giteasy.blog.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Axin in 2019/12/30 21:51
 */
@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRepository voteRepository;



    @Override
    @Transactional
    public void removeVote(Long id) {
        voteRepository.deleteById(id);
    }
    @Override
    public Vote getVoteById(Long id) {
        return voteRepository.findById(id).get();
    }


}
