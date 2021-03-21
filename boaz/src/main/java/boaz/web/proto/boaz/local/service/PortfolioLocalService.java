package boaz.web.proto.boaz.local.service;

import boaz.web.proto.boaz.impl.service.PortfolioServiceImpl;
import boaz.web.proto.boaz.local.domain.Blog;
import boaz.web.proto.boaz.local.domain.Portfolio;
import boaz.web.proto.boaz.local.domain.PortfolioDto;
import boaz.web.proto.boaz.local.handler.FileHandler;
import boaz.web.proto.boaz.local.repository.PortfolioJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioLocalService implements PortfolioServiceImpl {

    @Autowired
    private PortfolioJPARepository portfolioJPARepository;
    @Autowired
    private FileHandler fileHandler;

    public Optional<Portfolio> getPortfolio(Long id){
        Optional<Portfolio> portfolio = portfolioJPARepository.findById(id);
        return portfolio;
    }

    public void insertPortfolio(PortfolioDto portfolioDto){
        String fileSrc =  fileHandler.saveImage("test",portfolioDto.getFile());

        Portfolio portfolio = Portfolio.builder()
                .title(portfolioDto.getTitle())
                .id(portfolioDto.getId())
                .session(portfolioDto.getSession())
                .ckEditor(portfolioDto.getCkEditor())
                .file(fileSrc)
                .slideShareUrl(portfolioDto.getSlideShareUrl())
                .youtubeUrl(portfolioDto.getYoutubeUrl())
                .build();
        portfolioJPARepository.save(portfolio);

    }

    public void deletePortfolio(Long id){
        try {
            portfolioJPARepository.deleteById(id);
        }catch(Exception e){
            System.out.println("\n >> " + e.toString() + "\n >> There isn't a portfolio no." + id);
        }
    }

    public void modifyPortfolio(PortfolioDto portfolioDto){
        String fileSrc =  fileHandler.saveImage("test",portfolioDto.getFile());

        Portfolio portfolio = Portfolio.builder()
                .title(portfolioDto.getTitle())
                .id(portfolioDto.getId())
                .session(portfolioDto.getSession())
                .ckEditor(portfolioDto.getCkEditor())
                .file(fileSrc)
                .slideShareUrl(portfolioDto.getSlideShareUrl())
                .youtubeUrl(portfolioDto.getYoutubeUrl())
                .build();
        portfolioJPARepository.save(portfolio);
    }

    public List<Portfolio> getPortfolioList(){
        List<Portfolio> portfolioList = portfolioJPARepository.findAll();
        return portfolioList;
    }

}
