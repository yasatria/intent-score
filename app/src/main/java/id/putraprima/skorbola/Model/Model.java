package id.putraprima.skorbola.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Model implements Parcelable {

    private String homeName;
    private String awayName;
    private int homeScore;
    private int awayScore;
    private String winner;

    public Model(String homeName, String awayName) {
        this.homeName = homeName;
        this.awayName = awayName;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public String getAwayName() {
        return awayName;
    }

    public void setAwayName(String awayName) {
        this.awayName = awayName;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public static Creator<Model> getCREATOR() {
        return CREATOR;
    }

    protected Model(Parcel in) {
        homeName = in.readString();
        awayName = in.readString();
        homeScore = in.readInt();
        awayScore = in.readInt();
        winner = in.readString();
    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(homeName);
        dest.writeString(awayName);
        dest.writeInt(homeScore);
        dest.writeInt(awayScore);
        dest.writeString(winner);
    }
}
