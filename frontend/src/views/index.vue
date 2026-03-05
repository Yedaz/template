<template>
  <div class="common-layout">
    <el-container>
        <el-header style="height: 90px;">
            <Header></Header>
        </el-header>
      <el-container>
        <el-aside class="pdm-sidebar pdm-sidebar--dark">
          <LeftMenu></LeftMenu>
        </el-aside>
        <el-container>
            <div class="pdm-content_wrapper">
            <el-main class="pdm-content">
                <el-card :body-style="siteContent.siteContentHeight">
                <router-view></router-view>
                </el-card>
            </el-main>
                <el-footer class="layout-footer">
                    <Footer></Footer>
                </el-footer>
            </div>
        </el-container>
      </el-container>
    </el-container>
  </div>
</template>

<script setup lang="ts">
    import Header from '@/components/Header.vue';
    import LeftMenu from '@/components/LeftMenu.vue';
    import Footer from '@/components/Footer.vue';
    import { ref, reactive } from 'vue';
    /**
     * 定义内容区域常量 站点内容高度
     */
    const siteContent = reactive({
        documentClientHeight: 0,
        siteContentHeight: {}
    })

    function getSiteContentHeight() {
        //窗口的高度
        siteContent.documentClientHeight = document.documentElement.clientHeight;
        let hight = siteContent.documentClientHeight - 90 - 100;
        siteContent.siteContentHeight = {minHeight: hight + 'px'};
    }
    getSiteContentHeight();
    window.onresize = function() {
        getSiteContentHeight();
    }
</script>

<style lang="less">
    @import url('../styles/style.less');
</style>
