package com.mozhimen.utilk.android.view;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UtilKViewGroup
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/2/29
 * @Version 1.0
 */
public class UtilKViewGroup {
    public static List<View> findAllViews(ViewGroup viewGroup) {
        Deque<View> viewDeque = new ArrayDeque<>();
        viewDeque.add(viewGroup);
        ArrayList<View> views = new ArrayList<View>();
        while (!viewDeque.isEmpty()) {
            View node = viewDeque.removeFirst();
            if (node instanceof ViewGroup){
                int i = 0;
                int count = ((ViewGroup) node).getChildCount();
                while (i < count) {
                    viewDeque.add(((ViewGroup) node).getChildAt(i));
                    i++;
                }
            } else views.add(node);
        }
        return views;
    }

//    private static void collectTextViewTexts(ViewGroup viewGroup, Map<Integer, String> textsMap) {
//        Deque<View> viewDeque = new ArrayDeque<>();
//        viewDeque.add(viewGroup);
//        while (!viewDeque.isEmpty()) {
//            View node = viewDeque.removeFirst();
//            if (node instanceof ViewGroup){
//                int i = 0;
//                int count = ((ViewGroup) node).getChildCount();
//                while (i < count) {
//                    viewDeque.add(((ViewGroup) node).getChildAt(i));
//                    i++;
//                }
//            } else if (node instanceof TextView){
//                String str = ((TextView) node).getText().toString();
//                Log.d("letoast ViewText", "TextView: " + str);
//                textsMap.put(node.hashCode(),str);
//            }
//        }
//    }

//    private static void collectTextViewTexts(ViewGroup rootView, Map<Integer, String> textsMap) {
//        for (int i = 0; i < rootView.getChildCount(); i++) {
//            View child = rootView.getChildAt(i);
//            if (child instanceof ViewGroup) {
//                // 打印ViewGroup及其子类的类型
//                Log.d("letoast ViewType", "ViewGroup: " + child.getClass().getName());
//                collectTextViewTexts((ViewGroup) child, textsMap);
//            } else {
//
//                // 打印非ViewGroup类型的视图的类型
//                Log.d("letoast ViewType", "View: " + child.getClass().getName());
//                if (child instanceof TextView || child.getClass().getName().contains("DialogTitle")) {
//                    TextView textView = (TextView) child;
//                    String str = textView.getText().toString();
//                    textsMap.put(textView.hashCode(), str);
//                    // 打印TextView及其子类的文本
//                    Log.d("letoast ViewText", "TextView: " + str);
//                    collectTextViewTexts((ViewGroup) child, textsMap);
//                }
//            }
//        }
//    }
}
