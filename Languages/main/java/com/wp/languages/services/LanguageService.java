package com.wp.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wp.languages.models.Language;
import com.wp.languages.repositories.LanguageRepository;
@Service
public class LanguageService {
    private final LanguageRepository languageRepository;
    
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }

    public Language createLanguage(Language l) {
        return languageRepository.save(l);
    }
    
    public Language updateLanguage(Language l) {
    	return languageRepository.save(l);
    }
    
    public Language updateLanguage(Long id, String name, String creator, int currentVersion) {
    	
    	 Optional<Language> optionalLanguage = languageRepository.findById(id);
         if(optionalLanguage.isPresent()) {
             Language l = optionalLanguage.get();
             l.setName(name);
             l.setCreator(creator);
             l.setCurrentVersion(currentVersion);
             return languageRepository.save(l);
         } else {
             return null;
         }
         
    }
	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
		
	}
    // retrieves a book
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
}
