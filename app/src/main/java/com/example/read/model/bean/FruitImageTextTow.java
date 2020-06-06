package com.example.read.model.bean;

public class FruitImageTextTow {

        private String mContent;
        private int imageId;
        private String title;

        public FruitImageTextTow(String title,String mContent, int imageId) {
            this.imageId=imageId;
            this.mContent = mContent;
            this.title = title;
        }


        public String getContent(){
            return mContent;
        }

        public String getTitle(){
            return title;
        }


        public int getImageId() {
            return imageId;
        }

}
