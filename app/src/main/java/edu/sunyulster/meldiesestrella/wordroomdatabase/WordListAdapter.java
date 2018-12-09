package edu.sunyulster.meldiesestrella.wordroomdatabase;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meldiesestrella on 12/8/18.
 */

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordHolder> {

    private List<Word> mWords = new ArrayList<>();
    @Override
    public WordHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new WordHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordHolder holder, int position) {
          Word currentWord = mWords.get(position);
          holder.textViewWord.setText(currentWord.getWord());
          holder.textViewDef.setText(currentWord.getDef());

    }

    @Override
    public int getItemCount() {
        if (mWords != null)
            return  mWords.size();
        return 0;
    }

    public void setmWords(List<Word> words){
        this.mWords = words;
        notifyDataSetChanged();
    }

    class WordHolder extends RecyclerView.ViewHolder{
        private TextView textViewWord;
        private TextView textViewDef;

        public WordHolder(View itemView) {
            super(itemView);
            textViewWord = itemView.findViewById(R.id.text_view_word);
            textViewDef = itemView.findViewById(R.id.text_view_def);

        }
    }
}
