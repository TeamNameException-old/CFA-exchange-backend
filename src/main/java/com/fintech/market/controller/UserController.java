package com.fintech.market.controller;

import com.fintech.market.dto.CFA;
import com.fintech.market.entity.User;
import com.fintech.market.repos.UserRepos;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/users")
public class UserController {
    private final UserRepos userRepos;

    public UserController(UserRepos userRepos) {
        this.userRepos = userRepos;
    }

    @PostMapping("/create")
    public CFA.Owner create(@RequestBody CFA.Owner user) {
        User userEntity = new User(
                user.getUsername(),
                user.getOnline().getLast().getTime(),
                user.getRegistration().getDate().getTime(),
                user.getTransactions().getCount(),
                Integer.parseInt(user.getTransactions().getSuccessfully()),
                user.getActivity().getMonth().getOrders(),
                Integer.parseInt(user.getActivity().getMonth().getSuccessfully()),
                user.getActivity().getAverage().getTime().getSeconds().getTransfer(),
                user.getActivity().getAverage().getTime().getSeconds().getPayment());
        user.setId(userRepos.save(userEntity).getId());
        return user;
    }
}
