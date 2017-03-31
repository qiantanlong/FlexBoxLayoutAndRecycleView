package com.hongzhen.flexboxlayoutandrecycleview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;
import com.hongzhen.flexboxlayoutandrecycleview.R;
import com.hongzhen.flexboxlayoutandrecycleview.tools.PopWindowTool;

public class ActivityFlexBoxLayoutSimple extends AppCompatActivity {

    private FlexboxLayout mFlexboxLayout;
    String[] items = {"中国心", "寂寞沙洲冷", "过火", "最美中国人", "真的好想你", "最幸福的人", "双节棍", "苦行僧", "思念", "忘情水", "心花路放", "美丽新娘"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flex_box_layout_simple);
        addFlexBoxLayoutItem();
    }

    private void addFlexBoxLayoutItem() {
        mFlexboxLayout = (FlexboxLayout) findViewById(R.id.flexbox_layout);
// 通过代码向FlexboxLayout添加View
        for (int i = 0; i < items.length; i++) {
            final TextView textView = new TextView(this);
            textView.setBackground(getResources().getDrawable(R.drawable.label_bg_shape));
            textView.setText(items[i]);
            textView.setGravity(Gravity.CENTER);
            textView.setPadding(30, 15, 30, 15);
            textView.setTextColor(getResources().getColor(R.color.text_color));
            mFlexboxLayout.addView(textView);
            //通过FlexboxLayout.LayoutParams 设置子元素支持的属性
            ViewGroup.LayoutParams params = textView.getLayoutParams();
            /*if (params instanceof FlexboxLayout.LayoutParams) {
                FlexboxLayout.LayoutParams layoutParams = (FlexboxLayout.LayoutParams) params;
                layoutParams.setFlexBasisPercent(0.5f);
                /*
                layout_flexBasisPercent的值为一个百分比，
                表示设置子元素的长度为它父容器长度的百分比，
                如果设置了这个值，那么通过这个属性计算的值将会覆盖layout_width或者layout_height的值。
                但是需要注意，这个值只有设置了父容器的长度时才有效（也就是MeasureSpec mode 是 MeasureSpec.EXACTLY）。
                默认值时-1。

            }*/
            //设置FlexBoxeLayout子项的属性
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = ((ViewGroup) v.getParent()).indexOfChild(v);
                    Log.i("id", index + "");
//                    ((ViewGroup) v.getParent()).removeView(v);//删除当前子条目
                    addItem();//追加子条目
                }
            });
            textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    final View view=v;
                    int index = ((ViewGroup) v.getParent()).indexOfChild(v);
                    Log.i("id", index + "");
                    new PopWindowTool().showTipPopupWindow(textView, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ((ViewGroup) view.getParent()).removeView(view);//删除当前子条目
                        }
                    });
                    return true;
                }
            });
            if (params instanceof FlexboxLayout.LayoutParams) {
                FlexboxLayout.LayoutParams layoutParams = (FlexboxLayout.LayoutParams) params;
//                layoutParams.setFlexGrow(1);
                /*
                setFlexGrow()layout_flexGrow
                设置每个子项子元素的放大比例， 决定如何分配剩余空间（如果存在剩余空间的话），
                默认值为0,不会分配剩余空间，如果有一个item的 layout_flexGrow 是一个正值，
                那么会将全部剩余空间分配给这个Item,如果有多个Item这个属性都为正值，
                那么剩余空间的分配按照layout_flexGrow定义的比例（有点像LinearLayout的layout_weight属性）。
                 */
            }
        }

    }

    private void addItem() {
        TextView textView = new TextView(this);
        textView.setBackground(getResources().getDrawable(R.drawable.label_bg_shape));
        textView.setText("textView");
        textView.setGravity(Gravity.CENTER);
        textView.setPadding(30, 15, 30, 15);
        textView.setTextColor(getResources().getColor(R.color.text_color));
        mFlexboxLayout.addView(textView);
    }
}
