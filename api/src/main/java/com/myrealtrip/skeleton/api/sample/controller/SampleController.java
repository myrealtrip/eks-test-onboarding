package com.myrealtrip.skeleton.api.sample.controller;

import com.myrealtrip.skeleton.core.sample.http.dto.TestResponseSample;
import com.myrealtrip.skeleton.core.sample.member.dto.MemberDto;
import com.myrealtrip.skeleton.core.sample.member.dto.OrganizationDto;
import com.myrealtrip.skeleton.domain.sample.es.ElasticsearchSampleService;
import com.myrealtrip.skeleton.domain.sample.es.entity.Post;
import com.myrealtrip.skeleton.domain.sample.http.HttpSampleService;
import com.myrealtrip.skeleton.domain.sample.jpa.JpaSampleService;
import com.myrealtrip.skeleton.domain.sample.kafka.KafkaSampleService;
//import com.myrealtrip.skeleton.domain.sample.mybatis.MybatisSampleService;
//import com.myrealtrip.skeleton.domain.sample.redis.RedisSampleService;
import com.myrealtrip.skeleton.domain.sample.redis.entity.RedisSampleCache;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Sample Controller
 *
 * @author sarasu
 * @since 2021.10.08
 */
@Slf4j
@AllArgsConstructor
@RestController
public class SampleController {
//    private RedisSampleService redisSampleService;
    private JpaSampleService jpaSampleService;
    private KafkaSampleService kafkaSampleService;
    private ElasticsearchSampleService elasticsearchSampleService;
    private HttpSampleService httpSampleService;
//    private MybatisSampleService mybatisSampleService;

//    @GetMapping(path = "/sample/mybatis/member-retrieve")
//    @ApiOperation(value = "MyBatis 조회 API 샘플 - Dynamic Query")
//    public List<MemberDto> retrieveMember(MemberDto memberDto) {
//        return mybatisSampleService.findMember(memberDto);
//    }
//
//    @GetMapping(path = "/sample/mybatis/member")
//    @ApiOperation(value = "MyBatis ID 기반 조회")
//    public MemberDto getMemberByMybatis(@RequestParam("id") Long id) {
//        return mybatisSampleService.getMember(id);
//    }

//    @GetMapping(path = "/sample/mybatis/organization")
//    @ApiOperation(value = "MyBatis ID 기반 조회")
//    public OrganizationDto getOrganizationByMybatis(@RequestParam("id") Long id) {
//        return mybatisSampleService.getOrganization(id);
//    }

    @GetMapping(path = "/test-response")
    @ApiOperation(value = "Request Test용")
    public String testResponse() {
        return "{\"status\": \"OK\", \"type\" : \"test\"}";
    }

    @GetMapping(path = "/sample/http/sync")
    @ResponseBody
    @ApiOperation(value = "Sync HTTP Call Sample")
    public TestResponseSample httpSync() {
        return httpSampleService.callLocalhostPingSync();
    }

    @GetMapping(path = "/sample/http/async")
    @ApiOperation(value = "Async HTTP Call Sample")
    public String httpAsync() {
        httpSampleService.callLocalhostPingAsync();
        return "Async Call";
    }

    @GetMapping(path = "/sample/http/async-callback")
    @ApiOperation(value = "Async HTTP Call with Callback sample")
    public String httpAsyncCallback() {
        httpSampleService.callLocalhostPingAsyncWithCallback();
        return "Async Call with Callback";
    }

    @PutMapping(path = "/sample/es/save")
    @ApiOperation(value = "Elasticsearch 저장 샘플")
    public Post saveES(@RequestBody Post post) {
        return elasticsearchSampleService.savePost(post);
    }

    @GetMapping(path = "/sample/es/get")
    @ApiOperation(value = "Elasticsearch ID 기반 조회 샘플")
    public Post getEs(@RequestParam("id") String id) {
        return elasticsearchSampleService.findById(id).orElseThrow();
    }

    @GetMapping(path = "/sample/es/get-list")
    @ApiOperation(value = "Elasticsearch list 조회 샘플")
    public List<Post> getEsList(@RequestParam("title") String title) {
        return elasticsearchSampleService.findByTitle(title);
    }

    @GetMapping(path = "/sample/kafka/send")
    @ApiOperation(value = "Kafka publish sample")
    public void sendTopic(@RequestParam("topic") String topic, @RequestParam("payload") String payload) {
        kafkaSampleService.sendMessage(topic, payload);
    }

    @GetMapping(path = "/sample/kafka/sendWithCallback")
    @ApiOperation(value = "Kafka publish with callback sample")
    public void sendTopicWithCallback(@RequestParam("topic") String topic, @RequestParam("payload") String payload) {
        kafkaSampleService.sendMessageWithCallback(topic, payload);
    }

    @PutMapping(path = "/sample/jpa/member/save")
    @ApiOperation(value = "JPA 저장 샘플")
    public MemberDto saveMember(@RequestBody MemberDto memberDto) {
        return jpaSampleService.saveMember(memberDto);
    }

    @GetMapping(path = "/sample/jpa/organization/save")
    @ApiOperation(value = "JPA 저장 샘플")
    public OrganizationDto setOrganization(OrganizationDto organizationDto) {
        return jpaSampleService.saveOrganization(organizationDto);
    }

    @GetMapping(path = "/sample/jpa/member/{id}")
    @ApiOperation(value = "JPA ID 기반 조회")
    public MemberDto getMember(@PathVariable(name = "id") Long id) {
        return jpaSampleService.getMember(id);
    }

    @GetMapping(path = "/sample/jpa/organization/{id}")
    @ApiOperation(value = "JPA ID 기반 조회")
    public OrganizationDto getOrganization(@PathVariable(name = "id") Long id) {
        return jpaSampleService.getOrganization(id);
    }

//    @GetMapping(path = "/sample/redis/upsert")
//    @ApiOperation(value = "RedisTemplate 기반 저장")
//    public String redisSet(@RequestParam("key") String key, @RequestParam("value") String value) {
//        redisSampleService.set(key, value);
//        return "OK";
//    }
//
//    @GetMapping(path = "/sample/redis/get")
//    @ApiOperation(value = "RedisTemplate 기반 조회")
//    public String redisGet(@RequestParam("key") String key) {
//        return redisSampleService.get(key);
//    }
//
//    @GetMapping(path = "/sample/redis-hash/upsert")
//    @ApiOperation(value = "RedisHash 기반 저장")
//    public String redisHashSet(@RequestParam("key") Long key, @RequestParam("value") String value) {
//        RedisSampleCache cache = new RedisSampleCache(key, value);
//        redisSampleService.setRedisObject(cache);
//        return "OK";
//    }
//
//    @GetMapping(path = "/sample/redis-hash/get")
//    @ApiOperation(value = "RedisHash 기반 조회")
//    public RedisSampleCache redisHashGet(@RequestParam("key") Long key) {
//        Optional<RedisSampleCache> cache = redisSampleService.getRedisObject(key);
//
//        return cache.orElseGet(RedisSampleCache::new);
//    }
}
