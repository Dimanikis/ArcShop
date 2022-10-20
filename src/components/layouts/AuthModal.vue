<template>
  <div id="AuthModal" class="modal">
    <div class="modal-content">
      <div class="modal__header">
        <h1 v-if="signIn" class="modal__title">Authorization</h1>
        <h1 v-else class="modal__title">Registration</h1>
        <span @click="close" class="close">&times;</span>
      </div>
      <div class="modal__body">
        <form class="modal__auth">
          <div class="modal__block">
            <label for="login" class="modal__label">Username:</label>
            <input
              type="text"
              id="login"
              class="modal__input"
              placeholder="Enter Username"
            />
          </div>
          <div class="modal__block">
            <label for="pass" class="modal__label">Password:</label>
            <input
              type="password"
              id="pass"
              class="modal__input"
              placeholder="Enter Password"
            />
          </div>
          <GreenBtn v-if="signIn">Sign In</GreenBtn>
          <GreenBtn v-else>Sign Up</GreenBtn>
        </form>
        <div v-if="signIn" class="modal__choice">
          <span class="modal__text">New at this marketplace?</span>
          <button @click="signToggler" class="modal__btn">Sign Up</button>
        </div>
        <div v-else class="modal__choice">
          <span class="modal__text">Already have an existing profile?</span>
          <button @click="signToggler" class="modal__btn">Sign In</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import GreenBtn from "../GreenBtn.vue";
  export default {
    data() {
      return {
        signIn: true,
      };
    },
    methods: {
      signToggler() {
        return (this.signIn = !this.signIn);
      },
      close() {
        document.querySelector("#AuthModal").classList.remove("modal--active");
        document.body.classList.remove("nonscroll");
      },
    },
    components: { GreenBtn },
  };
</script>

<style lang="scss">
  .modal {
    display: block; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0, 0, 0); /* Fallback color */
    background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
    &--active {
      display: block;
    }
    &__header {
      display: flex;
      align-items: center;
      justify-content: space-between;
      border-bottom: 1px solid $color-neon-green;
    }
    &__title {
      line-height: 20px;
      font-size: 22px;
      font-weight: 500px;
    }
    &__choice {
      display: flex;
      justify-content: center;
      gap: 20px;
    }
    &__btn {
      cursor: pointer;
      border: $color-main-green;
    }
    &__block {
      display: flex;
      flex-direction: column;
      width: 100%;
    }
    &__auth {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      gap: 15px;
      margin: 20px 0;
    }
    &__label {
      line-height: 20px;
      font-size: 22px;
      font-weight: 500px;
      margin-bottom: 15px;
    }
    &__input {
      border: 1.5px solid rgb(197, 183, 183);
      font-size: 1.5em;
      padding: 5px 10px;
      width: 100%;
      border-radius: 15px;
      transition: border 1s ease;
      &:focus {
        border: 1.5px solid $color-neon-green;
        &::placeholder {
          color: transparent;
        }
      }
    }
  }

  /* Modal Content/Box */
  .modal-content {
    background-color: #fefefe;
    margin: 15% auto; /* 15% from the top and centered */
    padding: 20px;
    border: 1px solid #888;
    border-radius: 10px;
    width: 60%; /* Could be more or less, depending on screen size */
  }

  /* The Close Button */
  .close {
    color: #aaa;
    float: right;
    font-size: 40px;
    font-weight: bold;
  }

  .close:hover,
  .close:focus {
    color: black;
    text-decoration: none;
    cursor: pointer;
  }
</style>
