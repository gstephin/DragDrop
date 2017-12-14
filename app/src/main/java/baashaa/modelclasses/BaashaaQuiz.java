package baashaa.modelclasses;

import android.os.Parcel;
import android.os.Parcelable;

public class BaashaaQuiz extends BaashaaEntity implements Parcelable {
    int quizType= QuizType.QUIZE_TYPE_IMAGE_TO_TEXT;


    public int getQuizType() {
        return quizType;
    }

    public void setQuizType(int quizType) {
        this.quizType = quizType;
    }


    protected BaashaaQuiz(Parcel in) {
        super(in);
        quizType = in.readInt();
    }
    public BaashaaQuiz() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(quizType);
    }

    @SuppressWarnings("unused")
    public static final Creator<BaashaaQuiz> CREATOR = new Creator<BaashaaQuiz>() {
        @Override
        public BaashaaQuiz createFromParcel(Parcel in) {
            return new BaashaaQuiz(in);
        }

        @Override
        public BaashaaQuiz[] newArray(int size) {
            return new BaashaaQuiz[size];
        }
    };
}