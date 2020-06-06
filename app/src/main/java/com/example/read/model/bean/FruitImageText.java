package com.example.read.model.bean;

public class FruitImageText {

        private String mContent;
        private int imageId;

        public FruitImageText(String mContent, int imageId) {
            this.imageId=imageId;
            this.mContent = mContent;
        }


        public String getContent(){
            return mContent;
        }


        public int getImageId() {
            return imageId;
        }

}
