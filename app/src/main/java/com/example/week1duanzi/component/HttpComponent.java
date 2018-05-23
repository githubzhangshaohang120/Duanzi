package com.example.week1duanzi.component;

        import com.example.week1duanzi.module.HttpModule;
        import com.example.week1duanzi.ui.duanzi.DuanziFragment;

        import dagger.Component;

        @Component(modules = HttpModule.class)
        public interface HttpComponent {
        void inject(DuanziFragment duanziFragment);
        }
