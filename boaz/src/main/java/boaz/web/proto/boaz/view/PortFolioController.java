package boaz.web.proto.boaz.view;

import boaz.web.proto.boaz.local.domain.Portfolio;
import boaz.web.proto.boaz.local.domain.PortfolioDto;
import boaz.web.proto.boaz.local.service.PortfolioLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Controller
@RequestMapping("/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioLocalService portfolioLocalService;

    @GetMapping("")
    public String PortfolioPage(Model model){
        List<Portfolio> portfolioList = portfolioLocalService.getPortfolioList();
        model.addAttribute(portfolioList);

        return "user/portfolio";
    }

    @GetMapping("/{idx}")
    public ModelAndView PortfolioPage(@PathVariable("idx") Long id){
        Optional<Portfolio> portfolio = portfolioLocalService.getPortfolio(id);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/portfolio_detail");
        mav.addObject("portfolio",portfolio.orElse(null));

        return mav;
    }

    @PostMapping("/post")
    public String UploadPortfolio(PortfolioDto portfolioDto){
        portfolioLocalService.insertPortfolio(portfolioDto);

        return "user/portfolio";
    }

    @GetMapping("/modify/{idx}")
    public ModelAndView PortfolioModifyPage(@PathVariable("idx") Long id) {
        Optional<Portfolio> portfolio = portfolioLocalService.getPortfolio(id);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/portfolio_detail");
        mav.addObject("portfolio", portfolio.orElse(null));

        return mav;
    }

    @PostMapping("/modify")
    public String ModifyPortfolio(PortfolioDto portfolioDto){
        portfolioLocalService.modifyPortfolio(portfolioDto);
        return "user/portfolio";
    }

    @DeleteMapping("/delete/{idx}")
    public String DeletePortfolioPage(@PathVariable("idx") Long id){
        Optional<Portfolio> portfolio = portfolioLocalService.getPortfolio(id);

        if (isNull(portfolio)){
            System.out.println("cannot find portfolio");
            return "user/portfolio";
        }

        portfolioLocalService.deletePortfolio(id);

        return "user/portfolio";
    }
}
