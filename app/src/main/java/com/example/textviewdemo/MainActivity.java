package com.example.textviewdemo;

import android.app.Activity;
import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView mTv1,mTv2,mTv3,mTv4,mTv5,mTv6,mTv7;

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}
	private void initView(){
        mTv1 = (TextView)findViewById(R.id.tv1);
        mTv2 = (TextView)findViewById(R.id.tv2);
        mTv3 = (TextView)findViewById(R.id.tv3);
        mTv4 = (TextView)findViewById(R.id.tv4);
        mTv5 = (TextView)findViewById(R.id.tv5);
        mTv6 = (TextView)findViewById(R.id.tv6);
        mTv7 = (TextView)findViewById(R.id.tv7);



//设置文字前景色
        SpannableString spannableString = new SpannableString("文字的前景色为淡蓝色");
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#0099EE"));
        spannableString.setSpan(colorSpan, 7, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        mTv1.setText(spannableString);
        //设置文字背景色
        SpannableString spannableString1 = new SpannableString("文字的背景色为淡绿色");
        BackgroundColorSpan colorSpan1 = new BackgroundColorSpan(Color.parseColor("#AC00FF30"));
        spannableString.setSpan(colorSpan, 9, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        mTv2.setText(spannableString1);
        //设置文字相对大小
        RelativeSizeSpan sizeSpan01 = new RelativeSizeSpan(1.2f);
        RelativeSizeSpan sizeSpan02 = new RelativeSizeSpan(1.4f);
        RelativeSizeSpan sizeSpan03 = new RelativeSizeSpan(1.6f);
        RelativeSizeSpan sizeSpan04 = new RelativeSizeSpan(1.8f);
        RelativeSizeSpan sizeSpan05 = new RelativeSizeSpan(1.6f);
        RelativeSizeSpan sizeSpan06 = new RelativeSizeSpan(1.4f);
        RelativeSizeSpan sizeSpan07 = new RelativeSizeSpan(1.2f);

        spannableString.setSpan(sizeSpan01, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(sizeSpan02, 1, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(sizeSpan03, 2, 3, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(sizeSpan04, 3, 4, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(sizeSpan05, 4, 5, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(sizeSpan06, 5, 6, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(sizeSpan07, 6, 7, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        mTv3.setText(spannableString);
        //设置文字中划线
        SpannableString spannableString2 = new SpannableString("为文字设置删除线");
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        spannableString2.setSpan(strikethroughSpan, 5, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        mTv4.setText(spannableString2);
        //设置文字下划线
        SpannableString spannableString3= new SpannableString("为文字设置下划线");
        UnderlineSpan underlineSpan = new UnderlineSpan();
        spannableString3.setSpan(underlineSpan, 5, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        mTv5.setText(spannableString3);
        //为文字设置上标
        SpannableString spannableString4 = new SpannableString("为文字设置上标");
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        spannableString4.setSpan(superscriptSpan, 5, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        mTv4.setText(spannableString4);
        //为文字设置粗体
        SpannableString spannableString5 = new SpannableString("为文字设置粗体、斜体风格");
        StyleSpan styleSpan_B  = new StyleSpan(Typeface.BOLD);
        StyleSpan styleSpan_I  = new StyleSpan(Typeface.ITALIC);
        spannableString5.setSpan(styleSpan_B, 5, 7, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString5.setSpan(styleSpan_I, 8, 10, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        mTv6.setHighlightColor(Color.parseColor("#36969696"));
        mTv6.setText(spannableString5);
        //在文本中添加表情
        SpannableString spannableString6 = new SpannableString("在文本中添加表情（表情）");
        Drawable drawable = getResources().getDrawable(R.drawable.ic_launcher);
        drawable.setBounds(0, 0, 42, 42);
        ImageSpan imageSpan = new ImageSpan(drawable);
        spannableString6.setSpan(imageSpan, 6, 8, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        mTv7.setText(spannableString6);
        spannableString6 = new SpannableString("MaskFilterSpan -- http://orgcent.com");
        int length = spannableString6.length();
//模糊(BlurMaskFilter)
        MaskFilterSpan maskFilterSpan = new MaskFilterSpan(new BlurMaskFilter(3, BlurMaskFilter.Blur.OUTER));
        spannableString6.setSpan(maskFilterSpan, 0, length - 10, Spannable.
                SPAN_INCLUSIVE_EXCLUSIVE);
//浮雕(EmbossMaskFilter)
        maskFilterSpan = new MaskFilterSpan(new EmbossMaskFilter(new float[]{1,1,3}, 1.5f, 8, 3));
        spannableString6.setSpan(maskFilterSpan, length - 10, length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        mTv7.append("\n");
        mTv7.append(spannableString6);
        spannableString5 = new SpannableString("StrikethroughSpan");
        spannableString5.setSpan(new StrikethroughSpan(), 0, 7, Spannable.
                SPAN_INCLUSIVE_EXCLUSIVE);
        mTv5.append("\n");
        mTv5.append(spannableString5);
        spannableString4 = new SpannableString("UnderlineSpan");
        spannableString4.setSpan(new UnderlineSpan(), 0, spannableString4.length(),
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        mTv2.append("\n");
        mTv2.append(spannableString4);
        spannableString2 = new SpannableString("AbsoluteSizeSpan");
        spannableString2.setSpan(new AbsoluteSizeSpan(20, true), 0, spannableString2.length(),
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        mTv4.append("\n");
        mTv4.append(spannableString4);
        DynamicDrawableSpan drawableSpan =
                new DynamicDrawableSpan(DynamicDrawableSpan.ALIGN_BASELINE) {
                    @Override
                    public Drawable getDrawable() {
                        Drawable d = getResources().getDrawable(R.drawable.ic_launcher);
                        d.setBounds(0, 0, 50, 50);
                        return d;
                    }
                };
        DynamicDrawableSpan drawableSpan2 = new DynamicDrawableSpan(
                DynamicDrawableSpan.ALIGN_BOTTOM) {
            @Override
            public Drawable getDrawable() {
                Drawable d = getResources().getDrawable(R.drawable.ic_launcher);
                d.setBounds(0, 0, 50, 50);
                return d;
            }
        };
        spannableString4.setSpan(drawableSpan, 3, 4, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString4.setSpan(drawableSpan2, 7, 8, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        mTv5.append("\n");
        mTv5.append(spannableString4);
        spannableString = new SpannableString("RelativeSizeSpan");
//参数proportion:比例大小
        spannableString.setSpan(new RelativeSizeSpan(2.5f), 3, 4,
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        mTv1.append("\n");
        mTv1.append(spannableString);
        spannableString1 = new SpannableString("ScaleXSpan");
//参数proportion:比例大小
        spannableString.setSpan(new ScaleXSpan(3.8f), 3, 7, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        mTv2.append("\n");
        mTv2.append(spannableString1);
        spannableString1 = new SpannableString("TextAppearanceSpan ");
//若需自定义TextAppearance，可以在系统样式上进行修改
        spannableString1.setSpan(new TextAppearanceSpan(this, android.R.style.TextAppearance_Medium),
                6, 7, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        mTv4.append("\n");
        mTv4.append(spannableString1);
    }
}
