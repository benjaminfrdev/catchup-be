package com.project.be.api.service.impl;

import com.project.be.api.dto.AccountDTO;
import com.project.be.api.entity.AccountEntity;
import com.project.be.api.exception.InternalServerError;
import com.project.be.api.mapper.impl.AccountMapper;
import com.project.be.api.repository.IAccountRepository;
import com.project.be.api.service.IAccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {

    private final IAccountRepository accountRepository;
    private final AccountMapper accountMapper;
    public AccountService(IAccountRepository accountRepository, AccountMapper accountMapper){
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public Optional<AccountEntity> getAccountByPhoneNumber(String phoneNumber) {
        try{
            return accountRepository.findByPhoneNumber(phoneNumber);
        }catch (Exception e){
            throw new InternalServerError();
        }
    }

    @Override
    public List<AccountDTO> getAll() {
        try {
            return null;
        }catch (Exception e){
            throw new InternalServerError();
        }
    }

    @Override
    public void insert(AccountDTO accountDTO) {
        try{
            accountRepository.save(accountMapper.mapToEntity(accountDTO));
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new InternalServerError();
        }
    }

    @Override
    public void insertBulk(List<AccountDTO> accountDTO) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public AccountDTO getById(Long id) {
        return null;
    }


}
