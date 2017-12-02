package com.example.a.testdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private int size;
    private RecyclerView rvTest;
    private TextView tvSelect;
    private LjYyueAdapter ljYyueAdapter;
    private List<YydjOrderItemBean.ArtImage> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSelect = (TextView)findViewById(R.id.tv_select);
        rvTest = (RecyclerView) findViewById(R.id.rv_test);
        rvTest.setItemAnimator(new DefaultItemAnimator());
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvTest.setLayoutManager(staggeredGridLayoutManager);//设置RecyclerView布局管理器为2列垂直排布
        rvTest.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                staggeredGridLayoutManager.invalidateSpanAssignments();
            }
        });
        initData();

        tvSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectItem = ljYyueAdapter.getSelectItem();
                if (selectItem==-1){
                    Toast.makeText(MainActivity.this,"请选择item",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,""+selectItem,Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void initData() {
        ljYyueAdapter = new LjYyueAdapter(this);

        list = new ArrayList<YydjOrderItemBean.ArtImage>();

        for (int i=1;i<11;i++){
            YydjOrderItemBean.ArtImage bean = new YydjOrderItemBean.ArtImage();
            bean.month= "2017/"+i;
            list.add(bean);
        }
        final List<Integer> listOne = new ArrayList<Integer>();
        ljYyueAdapter.setClickListener(new LjYyueAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                RelativeLayout rlRoot = (RelativeLayout) view.findViewById(R.id.rl_root);

                for (int i=0;i<size;i++){
                    YydjOrderItemBean.ArtImage bean = list.get(i);
                    if (bean.status==1){
                        bean.status=0;
                    }
                    if (position==i){
                        bean.status=1;
                    }
                }
                ljYyueAdapter.notifyDataSetChanged();
            }
        });
        ljYyueAdapter.addData(list);
        size = list.size();
        rvTest.setAdapter(ljYyueAdapter);
    }
}
