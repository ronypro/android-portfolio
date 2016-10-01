package com.ronypro.android.portfolio;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahony on 01/10/16.
 */

public class PortfolioGridAdapter extends RecyclerView.Adapter<PortfolioGridAdapter.ViewHolder> {

    private List<Portfolio> portfolios;
    private Listener listener;

    public PortfolioGridAdapter(Listener listener) {
        this.portfolios = new ArrayList<>();
        this.listener = listener;
    }

    public void setPortfolios(List<Portfolio> portfolios) {
        this.portfolios = portfolios;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.portfolio_grid_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return portfolios.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Portfolio portfolio = getPortfolio(position);
        holder.nameTextView.setText(portfolio.name);
        Drawable icon = holder.itemView.getContext().getResources().getDrawable(portfolio.icon);
        holder.iconImageView.setImageDrawable(icon);
    }

    public Portfolio getPortfolio(int position) {
        return portfolios.get(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView nameTextView;
        private final ImageView iconImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            iconImageView = (ImageView) itemView.findViewById(R.id.iconImageView);
        }

        @Override
        public void onClick(View view) {
            Portfolio portfolio = getPortfolio(getAdapterPosition());
            listener.onPortfolioClick(portfolio);
        }
    }

    interface Listener {

        void onPortfolioClick(Portfolio portfolio);

    }

}
