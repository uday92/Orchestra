package edu.nyu.cs9053.homework5;

public class PrestissimoMusician implements Musician {

    private static final int PRESTISSIMO = 210;

    public void playDitty(DittyCallback dittyCallback, MusicalInstrument instrument, Note ... notes){

        final long thirtySecondsMs = 30000;
        final double scale = 100d;
        long millisecondsPause = thirtySecondsMs / notes.length;
        double conversion = (scale / (double) PRESTISSIMO);
        final long expectedMs = (long) (millisecondsPause * conversion);

        for(Note note : notes){
            instrument.play(new Rhythm() {
                @Override
                public long getDuration() {
                    return expectedMs - 3;
                }
            }, note, new NoteCallback() {
                @Override
                public void notePlayed(Note note) {
                }
            });
            dittyCallback.notePlayed(note);
        }
    }

    public long getTempo(){
        return PRESTISSIMO;
    }

}
