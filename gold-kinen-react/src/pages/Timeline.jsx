// import React from 'react';
import useFetchData from '../hooks/useFetchData';
import PostCard from '../components/PostCard';
import Loader from '../components/Loader';

import {motion} from "framer-motion"
const Timeline = () => {
  const { data, loading, error } = useFetchData();

  if (loading) return <Loader />;
  if (error) return <p>Error loading data: {error.message}</p>;

  const { posts, users, comments } = data;

  const getUserById = (id) => users.find(user => user.id === id);
  const getCommentsByPostId = (postId) => comments.filter(comment => comment.postId === postId);

  return (
    <div className='bg-black w-full'>
    <div className='bg-black w-full'>
      <motion.h1 initial={{ y: 0, opacity: 0 }}
        animate={{ y: 10, opacity: 1 }}
        transition={{ duration: 0.3, delay: 0.4 }} className='text-white text-center'>TimeLine</motion.h1>
    </div>
    <div className="container mx-auto mt-4 bg-white p-6">
      {posts.sort((a, b) => b.id - a.id).map((post,index) => (
        <motion.div key = {post.id} initial={{ y: 10, opacity: 0 }}
        animate={{ y: 0, opacity: 1 }}
        transition={{ duration: 0.5, delay: index * 0.6 }}>
        <PostCard  post={post} user={getUserById(post.userId)} comments={getCommentsByPostId(post.id)} />
        </motion.div>
      ))}
    </div>
    </div>
  );
};

export default Timeline;
