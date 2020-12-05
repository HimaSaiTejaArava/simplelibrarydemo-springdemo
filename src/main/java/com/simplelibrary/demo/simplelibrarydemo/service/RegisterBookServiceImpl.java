package com.simplelibrary.demo.simplelibrarydemo.service;

import com.simplelibrary.demo.simplelibrarydemo.dao.RegisterBookRepository;
import com.simplelibrary.demo.simplelibrarydemo.entity.RegisterBook;
import com.simplelibrary.demo.simplelibrarydemo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegisterBookServiceImpl implements RegisterBookServcie{

    private RegisterBookRepository registerBookRepository;

    public RegisterBookServiceImpl(RegisterBookRepository theRegisterBookRepository){
        registerBookRepository = theRegisterBookRepository;
    }

    @Override
    public List<RegisterBook> findAll() {
        return registerBookRepository.findAll();
    }

    @Override
    public RegisterBook findById(int theId) {

        Optional<RegisterBook> result = registerBookRepository.findById(theId);

        RegisterBook theRegisterBook = null;

        if(result.isPresent()) {
            theRegisterBook = result.get();
        }
        else {
            throw new RuntimeException("Did not find match with id : " + theId);
        }

        return theRegisterBook;
    }

    @Override
    public void save(RegisterBook theRegisterBook) {
        registerBookRepository.save(theRegisterBook);
    }

    @Override
    public void deleteById(int theId) {
        registerBookRepository.deleteById(theId);
    }
}
