package com.dubin.football.service.repository;

import com.dubin.football.database.dao.VisitorDao;
import com.dubin.football.service.util.UserDetailsConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VisitorServiceImpl implements VisitorService {

    private final VisitorDao visitorDao;
    private final UserDetailsConverter userDetailsConverter;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return visitorDao.findByName(name)
                .map(userDetailsConverter::convert)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
