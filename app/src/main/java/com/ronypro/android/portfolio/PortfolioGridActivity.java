package com.ronypro.android.portfolio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PortfolioGridActivity extends AppCompatActivity implements PortfolioGridAdapter.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio_grid);
        initList();
    }

    private void initList() {
        PortfolioGridAdapter portfolioGridAdapter = createPortfolioGridAdapter();
        RecyclerView portfolioRecyclerView = (RecyclerView) findViewById(R.id.portfolioRecyclerView);
        portfolioRecyclerView.setAdapter(portfolioGridAdapter);
    }

    private PortfolioGridAdapter createPortfolioGridAdapter() {
        List<Portfolio> portfolios = createPortfolios();
        PortfolioGridAdapter portfolioGridAdapter = new PortfolioGridAdapter(this);
        portfolioGridAdapter.setPortfolios(portfolios);
        return portfolioGridAdapter;
    }

    private List<Portfolio> createPortfolios() {
        List<Portfolio> portfolios = new ArrayList<>();
        int defaultIcon = R.drawable.ic_app_unknow_400dp;
        portfolios.add(new Portfolio(R.string.portfolio_popular_movies_name, R.drawable.ic_app_popular_movies_400dp));
        portfolios.add(new Portfolio(R.string.portfolio_stock_hawk_name, defaultIcon));
        portfolios.add(new Portfolio(R.string.portfolio_built_t_bigger_name, defaultIcon));
        portfolios.add(new Portfolio(R.string.portfolio_make_your_app_material_name, defaultIcon));
        portfolios.add(new Portfolio(R.string.portfolio_go_ubiquitous_name, defaultIcon));
        portfolios.add(new Portfolio(R.string.portfolio_capstone_name, defaultIcon));
        return portfolios;
    }

    @Override
    public void onPortfolioClick(Portfolio portfolio) {
        String portfolioName = getString(portfolio.name);
        String message = getString(R.string.toast_info_portfolio, portfolioName);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
