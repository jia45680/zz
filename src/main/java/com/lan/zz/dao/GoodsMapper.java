package com.lan.zz.dao;

import com.lan.zz.entity.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsMapper {

    @Select("SELECT c.a21 gid, c.a15 ticket, c.a2 gName, c.a8 cd, c.a9 gg, c.a5 number, c.a27 ph, c.scrq scrq, c.a28 yxq, z.tx_path, z.zj1_path, z.zj2_path, z.zj3_path, z.zj4_path, z.zj5_path, z.zj6_path, z.zj7_path, z.zj8_path, p.zz_path, p.zz_path1, p.zz_path2, p.zz_path3, p.zz_path4, p.zz_path5, p.zz_path6, p.zz_path7, p.zz_path8, p.zz_path9 FROM CHP c LEFT JOIN jhpzjtx z ON c.jhp_a35 = z.a35 LEFT JOIN ( SELECT gb.a21, zzb.zz_path, zzb.zz_path1, zzb.zz_path2, zzb.zz_path3, zzb.zz_path4, zzb.zz_path5, zzb.zz_path6, zzb.zz_path7, zzb.zz_path8, zzb.zz_path9 FROM GB, zzb WHERE gb.a25 = zzb.a25 AND zzb.zz_id = '45') p ON c.a21 = p.a21 WHERE a15 = #{ticket} AND c.kh_id = #{id}")
    List<Goods> selectGoodsByTicketAndId(@Param("ticket") String ticket, @Param("id") String id);
}
