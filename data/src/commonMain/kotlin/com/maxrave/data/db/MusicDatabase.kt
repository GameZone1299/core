package com.maxrave.data.db

import DatabaseDao
import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.maxrave.domain.data.entities.AlbumEntity
import com.maxrave.domain.data.entities.ArtistEntity
import com.maxrave.domain.data.entities.ArtistMotionEntity
import com.maxrave.domain.data.entities.AutoEqCurveEntity
import com.maxrave.domain.data.entities.AutoEqEntryEntity
import com.maxrave.domain.data.entities.AutoEqIndexMetaEntity
import com.maxrave.domain.data.entities.EpisodeEntity
import com.maxrave.domain.data.entities.FollowedArtistSingleAndAlbum
import com.maxrave.domain.data.entities.GoogleAccountEntity
import com.maxrave.domain.data.entities.LocalPlaylistEntity
import com.maxrave.domain.data.entities.LyricsEntity
import com.maxrave.domain.data.entities.NewFormatEntity
import com.maxrave.domain.data.entities.NotificationEntity
import com.maxrave.domain.data.entities.PairSongLocalPlaylist
import com.maxrave.domain.data.entities.PlaylistEntity
import com.maxrave.domain.data.entities.PodcastsEntity
import com.maxrave.domain.data.entities.QueueEntity
import com.maxrave.domain.data.entities.SearchHistory
import com.maxrave.domain.data.entities.SetVideoIdEntity
import com.maxrave.domain.data.entities.SongEntity
import com.maxrave.domain.data.entities.SongInfoEntity
import com.maxrave.domain.data.entities.TranslatedLyricsEntity
import com.maxrave.domain.data.entities.YourYouTubePlaylistList
import com.maxrave.domain.data.entities.analytics.EventArtistEntity
import com.maxrave.domain.data.entities.analytics.PlaybackEventEntity

@ConstructedBy(MusicDatabaseConstructor::class)
@Database(
    entities = [
        NewFormatEntity::class, SongInfoEntity::class, SearchHistory::class, SongEntity::class, ArtistEntity::class,
        AlbumEntity::class, PlaylistEntity::class, LocalPlaylistEntity::class, LyricsEntity::class, QueueEntity::class,
        SetVideoIdEntity::class, PairSongLocalPlaylist::class, GoogleAccountEntity::class, FollowedArtistSingleAndAlbum::class,
        NotificationEntity::class, TranslatedLyricsEntity::class, PodcastsEntity::class, EpisodeEntity::class,
        YourYouTubePlaylistList::class, PlaybackEventEntity::class, EventArtistEntity::class,
        AutoEqEntryEntity::class, AutoEqIndexMetaEntity::class, AutoEqCurveEntity::class,
        ArtistMotionEntity::class
    ],
    version = 27,
    autoMigrations = []
)
@TypeConverters(Converters::class)
abstract class MusicDatabase : RoomDatabase() {
    abstract fun getDatabaseDao(): DatabaseDao

    suspend fun vacuum() {
    }
}

expect fun getDatabaseBuilder(converters: Converters): RoomDatabase.Builder<MusicDatabase>
expect fun getDatabasePath(): String
