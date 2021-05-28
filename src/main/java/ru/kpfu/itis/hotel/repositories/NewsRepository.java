package ru.kpfu.itis.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.hotel.models.News;

import java.util.List;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 2
 */

public interface NewsRepository extends JpaRepository<News, Long> {

    @Query(nativeQuery = true, value =
            "WITH _news_title_tag AS (\n" +
            "    SELECT news.id, news.title, news.description, news.photo, news_tag.tag_id\n" +
            "    FROM news_hotel news\n" +
            "             LEFT JOIN news_tag on news.id = news_tag.news_id)\n" +
            "SELECT ntt.id, ntt.title, ntt.description, ntt.photo\n" +
            "FROM _news_title_tag ntt\n" +
            "         INNER JOIN tag_hotel tag ON tag.id = ntt.tag_id\n" +
            "WHERE tag.tag_name = :tag_name")
    List<News> findByTag(@Param("tag_name") String tagName);

}
